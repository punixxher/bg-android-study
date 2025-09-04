package com.bg.study.flow.application.usecases

import com.bg.study.flow.domain.model.DashboardData
import com.bg.study.flow.domain.repository.DashbaordRepository

class FetchDashboardUseCase(
    private val dashbaordRepository: DashbaordRepository
){
    suspend operator fun invoke(token: String): Result<DashboardData> {
        return dashbaordRepository.fetchDashboard(token)
    }
}