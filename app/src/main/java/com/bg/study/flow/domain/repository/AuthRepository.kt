package com.bg.study.flow.domain.repository

import com.bg.study.flow.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
    fun getCachedUser(): User?
}