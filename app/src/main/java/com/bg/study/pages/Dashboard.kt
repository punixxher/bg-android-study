package com.bg.study.pages

import android.graphics.drawable.Icon
import android.graphics.fonts.FontStyle
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bg.study.flow.domain.model.DashboardItem
import com.bg.study.flow.presentation.dashboard.DashboardViewModel
import com.bg.study.flow.presentation.login.LoginViewModel
import java.nio.file.WatchEvent

data class Transaction(
    val icon: ImageVector,
    val iconColor: Color,
    val bgColor: Color,
    val title: String,
    val subTitle: String,
    val amount: String,
    val time: String
)

@Composable
fun Header(name: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Bienvenido",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Text(text = name, style = MaterialTheme.typography.bodyMedium)
        }

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = "Avatar",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}


@Composable
fun Balance(UiState: DashboardViewModel.UiState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Balance de cuenta")
        Text(
            text = UiState.balance,
            fontSize = 48.sp,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
        Divider(modifier = Modifier.padding(top = 20.dp))
    }
}

@Composable
fun Statement() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Movimientos",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = Color(0xFFFF894F),
                contentColor = Color(0xFFFFFFFF)
            ),
            shape = RoundedCornerShape(27.dp)

        ) {

            Text("Ver Todo", style = MaterialTheme.typography.labelLarge)
        }
    }

}

@Composable
fun Transactions(t: Transaction) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .background(Color.White)
                .padding(horizontal = 14.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(t.bgColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = t.icon, contentDescription = null, tint = t.iconColor)
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = t.title)
            Text(text = t.subTitle)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(t.amount)
            Text(t.time)
        }
    }
    Spacer(Modifier.height(15.dp))
}

@Composable
private fun DashboardItemRow(item: DashboardItem) {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape).background(Color(0xFFE1E1E1)),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Outlined.Dashboard, contentDescription = null, tint = Color.Gray)
        }
        Spacer(Modifier.width(12.dp))
        Column {
            Text(text = item.title)
            Text(text = item.subtitle)
        }
    }
    Spacer(Modifier.height(15.dp))
}


@Composable
fun Dashboard(
    modifier: Modifier = Modifier
) {
    val isPreview = LocalInspectionMode.current
    val vm: DashboardViewModel? =
        if (isPreview) null else viewModel(factory = DashboardViewModel.factory())
    val uiState by (vm?.uiState?.collectAsState()
        ?: remember { mutableStateOf(DashboardViewModel.UiState()) })

    LaunchedEffect(Unit) {
        if (vm != null) vm.load()
    }


    val today =
        listOf(
            Transaction(
                Icons.Outlined.ShoppingBag,
                Color(0xFF14AE5C),
                Color(0x3314AE5C),
                "Supermercado",
                "SUPERMAXI",
                "-$75.56",
                "5:03 PM"
            ),
            Transaction(
                Icons.Outlined.DirectionsCar,
                Color(0xFF0B4BC9),
                Color(0xFF88A3D3),
                "Transporte",
                "Uber",
                "-$7.23",
                "3:40 PM"
            ),
        )

    val yesterday =
        listOf(
            Transaction(
                Icons.Outlined.ElectricBolt,
                Color(0xFF50057A),
                Color(0xFF9828E0),
                "Entretenimiento",
                "CINE",
                "-$10.17",
                "10:03 PM"
            ),
            Transaction(
                Icons.Outlined.Security,
                Color(0xFFA90016),
                Color(0xFFFF4D66),
                "Salud",
                "MEDICITY",
                "-$25.00",
                "11:40 AM"
            ),
        )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item { Spacer(Modifier.height(30.dp)) }
        item { Header("Daniel Silva") }
        item { Spacer(Modifier.height(30.dp)) }
        item { Balance(uiState) }
        item { Spacer(Modifier.height(12.dp)) }
        item { Statement() }
        item { Spacer(Modifier.height(12.dp)) }
        item { Text("Notificaciones") }
        item { Spacer(Modifier.height(12.dp)) }
        when {
            uiState.items.isNullOrEmpty() -> {
                items(uiState.items) { tx -> DashboardItemRow(tx) }
            }
        }
        item { Text("Ayer") }
        item { Spacer(Modifier.height(12.dp)) }
        items(yesterday) { tx -> Transactions(tx) }
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewDashboard() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        Dashboard()
    }
}