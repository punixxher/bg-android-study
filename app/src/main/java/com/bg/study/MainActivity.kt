package com.bg.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.bg.study.pages.App
import com.bg.study.pages.GridSample
import com.bg.study.pages.LayoutBasic
import com.bg.study.pages.LayoutComplet
import com.bg.study.pages.LazyColumnComponent
import com.bg.study.pages.TextBasicExample


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MaterialTheme{
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ExamplesHome()
                }
            }
        }
    }
}


private class Example(
    val title: String,
    val content: @Composable () -> Unit
)


@Composable
private fun ExamplesHome() {
    var current: Example? by remember { mutableStateOf(null) }

    val examplesScreens = remember {
        listOf(
            Example("Elementos Basicos") { App() },
            Example("Layout Basico") { LayoutBasic() },
            Example("Lazy Column") { LazyColumnComponent() },
            Example("Grid Sample") { GridSample() },
            Example("Layout Complete") { LayoutComplet() },
            Example("Text Basics") { TextBasicExample() }
        )
    }
    if (current == null) {
        LazyColumn {
            item {
                Text(text = "Ejemplos componentes Compose")
            }
            items(examplesScreens) { ex ->
                Button(onClick = { current = ex }) {
                    Text(ex.title)
                }
            }
        }
    }else {
        Column {
            Button(onClick = {current = null}) { Text("Volver") }
            Text(text = current!!.title)
            current!!.content()
        }
    }
}



