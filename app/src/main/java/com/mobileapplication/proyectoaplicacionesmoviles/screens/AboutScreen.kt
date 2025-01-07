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
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Preview
@Composable
fun AboutScren(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.size(16.dp))
        AboutBody()
    }
}
@Composable
fun AboutBody(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Acerca de la aplicación",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = BlueSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.emocional),
            contentDescription = "Imagen de bienvenida",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "EMOI",
            fontWeight = FontWeight.SemiBold,

            fontSize = 24.sp,
            color = BlueSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Version 0.0.1",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,

        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Fecha de creación 01/01/2025",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Todos los derechos reservados",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}

