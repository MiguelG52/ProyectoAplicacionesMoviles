package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.net.Uri
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.CardContent
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthManager
import com.mobileapplication.proyectoaplicacionesmoviles.models.Content
import com.mobileapplication.proyectoaplicacionesmoviles.navigation.ContentDetails
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun HomeScreen(navController: NavHostController, authManager: AuthManager) {

    var libros by remember { mutableStateOf<List<Content>>(emptyList()) }
    var videos by remember { mutableStateOf<List<Content>>(emptyList()) }
    var recetas by remember { mutableStateOf<List<Content>>(emptyList()) }
    var ejercicios by remember { mutableStateOf<List<Content>>(emptyList()) }

    LaunchedEffect(Unit) {
        videos = authManager.fetchVideos()
        recetas = authManager.fetchRecetas()
        libros = authManager.fetchLibros()
        ejercicios = authManager.fetchEjercicios()

        Log.d("VideosContent", "Videos: $videos")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 4.dp, vertical = 12.dp)
    ){
        HomeScreenBody(navController, videos, recetas, ejercicios, libros)
    }
}

@Composable
fun HomeScreenBody(navController: NavHostController, videos: List<Content>, recetas: List<Content>, ejercicios: List<Content>, libros: List<Content>) {
    Column{
        HomeOption(navController,icon = R.drawable.video_gallery_solid, label = "Videos", content = videos)
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(navController, icon = R.drawable.manzana, label = "Recetas", content = recetas)
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(navController, icon = R.drawable.fisico, label = "Ejercicios", content =  ejercicios)
        Spacer(modifier = Modifier.size(8.dp))
        HomeOption(navController, icon = R.drawable.libro, label = "Libros", content =  libros)

    }
}
@Composable
fun HomeOption(navController: NavHostController, icon: Int, label: String, content: List<Content>) {

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
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start) {

            content.forEach { item ->
                val encodedString = URLEncoder.encode(Json.encodeToString(item), StandardCharsets.UTF_8.toString())
                    .replace("+", "%20")

                CardContent(
                    navigate = { navController.navigate("contentDetails/${encodedString}") },
                    content = item
                )
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }

}
