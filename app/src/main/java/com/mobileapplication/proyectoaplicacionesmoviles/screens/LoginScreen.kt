package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.Input
import com.mobileapplication.proyectoaplicacionesmoviles.components.PrimaryButton
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthManager
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthRes
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(navigateToHome: () -> Unit, auth: AuthManager) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center
    ){
        LoginHeader()
        Spacer(modifier = Modifier.size(16.dp))
        LoginBody(navigateToHome, auth)
    }
}

@Composable
fun LoginHeader(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Inicia Sesión",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = BlueSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.brain),
            contentDescription = "Imagen de bienvenida",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Bienvenido de vuelta!",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginBody(navigateToHome: () -> Unit, auth: AuthManager) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column {
        Input( value = email, onValueChange = { email = it } ,name = "Email", type = "text", placeholder =  "Ingresa tu email", icon = painterResource(id = R.drawable.email))
        Spacer(modifier = Modifier.size(16.dp))
        Input(value = password, onValueChange = {password = it},name = "Contraseña", type = "password", placeholder = "Ingresa tu contraseña", icon = painterResource(id = R.drawable.lock))
        Spacer(modifier = Modifier.size(26.dp))
        PrimaryButton(text = "Iniciar Sesión", onClick = {
            scope.launch {
                signInUser(
                    email = email,
                    password = password,
                    navigateToHome = navigateToHome,
                    context = context, auth = auth )
            }
        })
    }
}

private suspend fun signInUser(email: String, password: String, navigateToHome: () -> Unit, context:Context, auth: AuthManager ){
    if(email.isNotEmpty() && password.isNotEmpty()) {
        when (val result = auth.signInWithEmailAndPassword(email, password)) {
            is AuthRes.Success -> {
                navigateToHome()
            }
            is AuthRes.Error -> {
                Toast.makeText(context, "Error SignUp: ${result.errorMessage}", Toast.LENGTH_SHORT).show()
            }

        }
    } else {
        Toast.makeText(context, "Existen campos vacios", Toast.LENGTH_SHORT).show()
    }


}