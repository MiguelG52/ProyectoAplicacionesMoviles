package com.mobileapplication.proyecto.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyecto.R

@Composable
fun HomeScreen(navigateToDetails: (String) -> Unit) {
    var selectedCategory by remember { mutableStateOf("Videos") }
    val contentList = when (selectedCategory) {
        "Videos" -> listOf("Video 1", "Video 2", "Video 3")
        "Libros" -> listOf("Libro 1", "Libro 2", "Libro 3")
        "Recetas" -> listOf("Receta 1", "Receta 2", "Receta 3")
        "Ejercicios" -> listOf("Ejercicio 1", "Ejercicio 2", "Ejercicio 3")
        else -> emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            HomeOption(icon = R.drawable.comment_video, label = "Videos") {
                selectedCategory = "Videos"
            }
            HomeOption(icon = R.drawable.libro, label = "Libros") {
                selectedCategory = "Libros"
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            HomeOption(icon = R.drawable.appl, label = "Recetas") {
                selectedCategory = "Recetas"
            }
            HomeOption(icon = R.drawable.fisico, label = "Ejercicios") {
                selectedCategory = "Ejercicios"
            }
        }

        LazyColumn {
            items(contentList) { content ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .background(Color.LightGray)
                        .clickable {
                            navigateToDetails(content) // Navegar al detalle con el contenido seleccionado
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = content, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}


@Composable
fun HomeOption(icon: Int, label: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray, CircleShape)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(painter = painterResource(icon), contentDescription = label)
        }
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
    }
}
