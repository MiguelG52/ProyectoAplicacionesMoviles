package com.mobileapplication.proyectoaplicacionesmoviles.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.HomeOption

@Preview
@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 4.dp, vertical = 12.dp)
    ){
        HomeScreenBody()
    }
}

@Composable
fun HomeScreenBody(){
    Column{
        HomeOption(icon = R.drawable.video_gallery_solid, label = "Videos")
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(icon = R.drawable.manzana, label = "Recetas")
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(icon = R.drawable.fisico, label = "Ejercicios")
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(icon = R.drawable.libro, label = "Libros")
    }
}