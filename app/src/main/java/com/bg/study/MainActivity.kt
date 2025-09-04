package com.bg.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.bg.study.pages.Dashboard
import com.bg.study.pages.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlowRoot()
                }
            }
        }
    }
}


@Composable
private fun FlowRoot() {
    var loggerIn by remember { mutableStateOf(false) }
    if (!loggerIn) {
        LoginScreen(onLoggedIn = { loggerIn = true })
    } else {
        Dashboard()
    }
}






