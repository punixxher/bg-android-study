package com.bg.study.flow.domain.repository

import com.bg.study.flow.domain.model.DashboardData

interface DashbaordRepository {
    suspend fun fetchDashboard(token: String): Result<DashboardData>
}