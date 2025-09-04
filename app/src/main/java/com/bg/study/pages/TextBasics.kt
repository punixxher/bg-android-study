package com.bg.study.pages

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextBasicExample() {
    Column(modifier = Modifier.padding(18.dp)) {
        Text("Titulo H5", style = MaterialTheme.typography.headlineSmall)
        Text("Titulo M", style = MaterialTheme.typography.titleMedium)
        Text("Cuepo", style = MaterialTheme.typography.bodyMedium)

        Text(
            "Texto con negrita con Italica",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        Text(text = "Tamano personalizado", fontSize = 40.sp)

        Text(text = "Texto en el centro", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}
