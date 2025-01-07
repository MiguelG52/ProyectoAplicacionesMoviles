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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.PrimaryButton
import com.mobileapplication.proyectoaplicacionesmoviles.components.SecondaryButton

import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Preview
@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Header(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(16.dp))
        Body(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun Header(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hola!")
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.brain),
            contentDescription = "Imagen de bienvenida",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(text = "Tu salud mental es importante!" ,fontSize = 20.sp,
            color = BlueSecondary,
            fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Regístrate ahora para iniciar tu viaje")
    }
}

@Composable
fun Body(modifier: Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 32.dp, vertical = 16.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PrimaryButton(text = "Iniciar Sesión", onClick = { })
        Spacer(modifier = Modifier.size(16.dp))
        SecondaryButton(text = "Crear Cuenta", onClick = { })
    }
}

