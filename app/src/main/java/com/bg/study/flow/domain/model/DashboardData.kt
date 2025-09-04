package com.bg.study.flow.domain.model

data class DashboardData (
    val balance: String,
    val items: List<DashboardItem>
)

data class DashboardItem(
    val id: String,
    val title: String,
    val subtitle: String,
)