package com.bg.study.flow.presentation.login

import android.view.View
import com.bg.study.flow.application.usecases.LoginUseCase
import com.bg.study.flow.domain.model.User
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bg.study.flow.di.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): ViewModel() {
    sealed class UiState {
        object Idle: UiState()
        object Loading: UiState()
        data class Succes(val user: User): UiState()
        data class Error(val message: String): UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()



    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = loginUseCase(email, password)
            _uiState.value = result.fold(
                onSuccess = {UiState.Succes(it)},
                onFailure = {UiState.Error(it.message ?: "Error desconocido")}
            )
        }
    }

    companion object{
        fun factory(): ViewModelProvider.Factory = object: ViewModelProvider.Factory {
            override fun <T: ViewModel> create(modelClass: Class<T>): T {
                return LoginViewModel(
                    ServiceLocator.loginUseCase
                ) as T
            }
        }
    }

}