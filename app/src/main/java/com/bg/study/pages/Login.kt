package com.bg.study.pages

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bg.study.flow.presentation.login.LoginViewModel


@Composable
fun LoginScreen(modifier: Modifier = Modifier, onLoggedIn: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var accepted by remember { mutableStateOf(true) }


    val isPreview = LocalInspectionMode.current
    val vm: LoginViewModel? = if (isPreview) null else viewModel(factory = LoginViewModel.factory())
    val uiState by (vm?.uiState?.collectAsState() ?: remember { mutableStateOf<LoginViewModel.UiState>(LoginViewModel.UiState.Idle) })
    if(uiState is LoginViewModel.UiState.Succes) {
        LaunchedEffect(uiState) { onLoggedIn()}
    }

    Box(modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFDCDCDC))
            ) {
                Text("", fontSize = 12.sp)
            }

            Spacer(Modifier.height(25.dp))
            Text(
                text = "Sign up", modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Text(
                "Email", Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(25.dp))
            Text(
                "Password", Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(checked = accepted, onCheckedChange = { accepted = it })
                Spacer(Modifier.width(8.dp))
                Text("Acepto terminos y condiciones")
            }

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = { vm?.login(email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) { Text("Ingresar", fontSize = 16.sp, fontWeight = FontWeight.SemiBold) }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    MaterialTheme {
        Surface { LoginScreen(Modifier.padding(top = 40.dp)) }
    }
}