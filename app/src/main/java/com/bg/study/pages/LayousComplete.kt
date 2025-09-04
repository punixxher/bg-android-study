package com.bg.study.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun LayoutComplet() {
    Column {
        Text("Elementos vertivales")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF625b71))
                .padding(8.dp)
        ) {
            Text("Elemento 1 ")
            Text("Elemento 2")
            Text("Elemento 3")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Elementos Horizontales")
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFCCC2DC))
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Inicio")
            Box(modifier = Modifier
                .size(32.dp)
                .background(Color(0xFFEFB8C8)))
            Text("Fin")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth().height(120.dp).background(Color(0xFF625b71))){
            Box(modifier = Modifier.size(60.dp).background(Color(0xFFD0BCFF)))
            Box(modifier = Modifier.size(40.dp).background(Color(0xFF7D5260)).align(Alignment.Center))
            Text(text = "Abajo-derecha", modifier = Modifier.align(Alignment.BottomEnd))
        }




    }
}