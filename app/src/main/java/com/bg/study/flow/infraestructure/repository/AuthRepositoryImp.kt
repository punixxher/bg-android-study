package com.bg.study.flow.infraestructure.repository

import com.bg.study.flow.domain.model.User
import com.bg.study.flow.domain.repository.AuthRepository
import com.bg.study.flow.infraestructure.datasource.AssetsDataSource
import kotlinx.coroutines.*

class AuthRepositoryImp(private val dataSource: AssetsDataSource) : AuthRepository {

    private var cachedUser: User? = null

    override suspend fun login(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            runCatching {
                val json = dataSource.readAsset("mock_user.json")
                val user = dataSource.parseUser(json)
                cachedUser = user
                user
            }
        }
    }

    override fun getCachedUser(): User? = cachedUser
}