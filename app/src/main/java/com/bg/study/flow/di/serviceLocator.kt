package com.bg.study.flow.di

import android.content.Context
import com.bg.study.flow.application.usecases.FetchDashboardUseCase
import com.bg.study.flow.application.usecases.LoginUseCase
import com.bg.study.flow.infraestructure.datasource.AssetsDataSource
import com.bg.study.flow.infraestructure.repository.AuthRepositoryImp
import com.bg.study.flow.infraestructure.repository.DashboarRepositoryImp

object ServiceLocator {
    private lateinit var assetDataSourse: AssetsDataSource

    // Repositorios
    private val authRepository by lazy { AuthRepositoryImp(assetDataSourse) }
    private val dashbaordRepository by lazy { DashboarRepositoryImp(assetDataSourse) }

    val loginUseCase by lazy { LoginUseCase(authRepository) }
    val fetchDashboardUseCase by lazy { FetchDashboardUseCase(dashbaordRepository) }

    fun init(appContext: Context) {
        if(!this::assetDataSourse.isInitialized){
            assetDataSourse = AssetsDataSource(appContext)
        }
    }
}