package com.bg.study.flow.application.usecases

import com.bg.study.flow.domain.model.User
import com.bg.study.flow.domain.repository.AuthRepository

class GetCachedUserUseCase(private val authRepository: AuthRepository) {
    operator fun invoke(): User? = authRepository.getCachedUser()
}