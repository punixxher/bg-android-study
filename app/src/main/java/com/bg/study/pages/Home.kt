package com.bg.study.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns

@Composable
fun HomeScreen() {
    Column(Modifier
        .padding(20.dp)
        .fillMaxHeight(1f)) {
        Text("Hola Compose")
        Spacer(Modifier.height(30.dp))
        Row(Modifier
            .background(Color(0xFFEFB8C8))
            .fillMaxWidth()) {
            Icon(Icons.Default.Favorite, contentDescription = null)
            Text("Me gusta")
        }
        Spacer(Modifier.height(30.dp))
        Button(onClick = {}) { Text("Comprar") }
        Spacer(Modifier.height(30.dp))
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp)) {
                Text("Card Titulo", style = MaterialTheme.typography.titleLarge)
                Text("Description de esta Card")
            }
        }
    }
}