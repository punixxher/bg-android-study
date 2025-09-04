
package com.bg.study.flow.application.usecases

import com.bg.study.flow.domain.model.User
import com.bg.study.flow.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository){
    suspend operator fun invoke(email: String, password: String): Result<User>{
        return authRepository.login(email, password)
    }
}