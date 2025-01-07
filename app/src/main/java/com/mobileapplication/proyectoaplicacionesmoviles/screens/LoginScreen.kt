package com.mobileapplication.proyectoaplicacionesmoviles.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.Input
import com.mobileapplication.proyectoaplicacionesmoviles.components.PrimaryButton
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BluePrimary
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Preview
@Composable
fun LoginScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center
    ){
        LoginHeader()
        Spacer(modifier = Modifier.size(16.dp))
        LoginBody()
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
fun LoginBody() {
    Column {
        Input("Email", "text", "Ingresa tu email", icon = painterResource(id = R.drawable.email)) {}
        Spacer(modifier = Modifier.size(16.dp))
        Input("Contraseña", "password", "Ingresa tu contraseña", icon = painterResource(id = R.drawable.lock)) {}
        Spacer(modifier = Modifier.size(26.dp))
        PrimaryButton(text = "Iniciar Sesión", onClick = { })
    }
}