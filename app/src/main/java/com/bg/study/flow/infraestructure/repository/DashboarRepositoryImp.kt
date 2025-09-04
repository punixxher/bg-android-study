package com.bg.study.flow.infraestructure.repository

import com.bg.study.flow.domain.model.DashboardData
import com.bg.study.flow.domain.repository.DashbaordRepository
import com.bg.study.flow.infraestructure.datasource.AssetsDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DashboarRepositoryImp(private val dataSource: AssetsDataSource): DashbaordRepository {
    override suspend fun fetchDashboard(token: String): Result<DashboardData>  = withContext(Dispatchers.IO){
        runCatching {
            val json = dataSource.readAsset("mock_dashboard.json")
            dataSource.parseDashboard(json)
        }
    }
}