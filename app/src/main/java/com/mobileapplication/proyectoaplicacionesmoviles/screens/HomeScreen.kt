package com.mobileapplication.proyectoaplicacionesmoviles.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.HomeOption

@Preview
@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center
    ){
        HomeScreenBody()
    }
}

@Composable
fun HomeScreenBody(){
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        HomeOption(icon = R.drawable.video_gallery_solid, label = "Videos")
        HomeOption(icon = R.drawable.manzana, label = "Recetas")
    }
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly){
        HomeOption(icon = R.drawable.fisico, label = "Ejercicios")
        HomeOption(icon = R.drawable.libro, label = "Libros")
    }
}