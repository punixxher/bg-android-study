package com.bg.study.flow.infraestructure.datasource

import android.content.Context
import com.bg.study.flow.domain.model.DashboardData
import com.bg.study.flow.domain.model.DashboardItem
import com.bg.study.flow.domain.model.User
import org.json.JSONObject

class AssetsDataSource(private val context: Context) {



    fun readAsset(fileName: String): String =
        context.assets.open(fileName).bufferedReader().use { it.readText() }

    fun parseUser(json: String): User {
        val obj = JSONObject(json)
        return User(
            id = obj.getString("id"),
            name = obj.getString("name"),
            email = obj.getString("email"),
            token = obj.getString("token"),
        )
    }

    fun parseDashboard(json: String): DashboardData {
        val obj = JSONObject(json)
        val balance = obj.optString("balance", "")
        val arr = obj.getJSONArray("items")
        val items = ArrayList<DashboardItem>(arr.length())

        for (i in 0 until arr.length()) {
            val o = arr.getJSONObject(i)
            items.add(
                DashboardItem(
                    id = o.getString("id"),
                    title = o.getString("title"),
                    subtitle = o.getString("subtitle"),
                )
            )
        }
        return DashboardData(balance, items)
    }
}