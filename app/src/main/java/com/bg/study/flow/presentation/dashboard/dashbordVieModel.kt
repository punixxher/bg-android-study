package com.bg.study.flow.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bg.study.flow.application.usecases.FetchDashboardUseCase
import com.bg.study.flow.application.usecases.GetCachedUserUseCase
import com.bg.study.flow.domain.model.DashboardItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(private val fetchDashboardUseCase: FetchDashboardUseCase, private val getCachedUserUseCase: GetCachedUserUseCase): ViewModel() {
    data class UiState(
        val loading: Boolean = false,
        val balance: String = "",
        val items: List<DashboardItem> = emptyList(),
        val error: String? = null
    )

    private val _uiState = MutableStateFlow(UiState())

    fun load(){
        val token = getCachedUserUseCase()?.token
        if(token.isNullOrEmpty()){
            _uiState.value = UiState(loading = false, error = "Usuario no se encuentra logeado")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(loading = true, error = null)
            val result = fetchDashboardUseCase(token)
            _uiState.value = result.fold(
                onSuccess = {
                    UiState(loading = false, items = it.items, error = null, balance = it.balance)
                },
                onFailure = { UiState(loading = false, error = it.message ?: "Error")}
            )
        }
    }
}