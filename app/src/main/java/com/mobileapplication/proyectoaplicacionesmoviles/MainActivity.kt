package com.mobileapplication.proyectoaplicacionesmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mobileapplication.proyectoaplicacionesmoviles.screens.LoginScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.WelcomeScreen
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.ProyectoAplicacionesMovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionesMovilesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen()
                }
            }
        }
    }
}
