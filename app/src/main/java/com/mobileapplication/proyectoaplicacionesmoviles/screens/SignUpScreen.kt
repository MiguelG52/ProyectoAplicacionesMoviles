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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.Input
import com.mobileapplication.proyectoaplicacionesmoviles.components.PrimaryButton
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Preview
@Composable
fun SignUpScreen(){
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp), Arrangement.Center
    ){
        SignUpHeader()
        Spacer(modifier = Modifier.size(16.dp))
        SignUpForm()
    }
}
@Composable
fun SignUpHeader(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crea una cuenta",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = BlueSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.profesional),
            contentDescription = "Imagen de bienvenida",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Inicia tu camino a una mejor salud mental!",
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun SignUpForm(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Input("Name", "text", "Ingresa tu nombre", icon = painterResource(id = R.drawable.wing)) {}
        Spacer(modifier = Modifier.size(16.dp))
        Input("Fecha de Nacimiento", "date", placeholder = "Ingresa tu fecha de nacimiento", icon = painterResource(id = R.drawable.icon_calendario_morado)) {}
        Spacer(modifier = Modifier.size(16.dp))
        Input("Email", "text", "Ingresa tu email", icon = painterResource(id = R.drawable.email)) {}
        Spacer(modifier = Modifier.size(16.dp))
        Input("Contraseña", "password", "Ingresa tu email", icon = painterResource(id = R.drawable.lock)) {}
        Spacer(modifier = Modifier.size(26.dp))
        PrimaryButton(text = "Crear cuenta", onClick = { })
    }
}