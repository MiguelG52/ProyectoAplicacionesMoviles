package com.mobileapplication.proyectoaplicacionesmoviles.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.CardContent
import com.mobileapplication.proyectoaplicacionesmoviles.navigation.ContentDetails


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 4.dp, vertical = 12.dp)
    ){
        HomeScreenBody(navController)
    }
}

@Composable
fun HomeScreenBody(navController: NavHostController) {
    Column{
        HomeOption(navController,icon = R.drawable.video_gallery_solid, label = "Videos")
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(navController,icon = R.drawable.manzana, label = "Recetas")
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(navController,icon = R.drawable.fisico, label = "Ejercicios")
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(navController,icon = R.drawable.libro, label = "Libros")

    }
}
@Composable
fun HomeOption(navController: NavHostController, icon: Int, label: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(Color.White, shape = RoundedCornerShape(5.dp))
        .border(1.dp, Color.White, shape = RoundedCornerShape(5.dp))
    ){
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
            Image(painter = painterResource(icon), contentDescription = label, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = label, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.size(2.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp).horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            CardContent({ navController.navigate(ContentDetails) }, label)
            Spacer(modifier = Modifier.size(8.dp))
            CardContent({ navController.navigate(ContentDetails) }, label)
            Spacer(modifier = Modifier.size(8.dp))
            CardContent({ navController.navigate(ContentDetails) }, label)
        }
    }

}
