package com.mobileapplication.proyectoaplicacionesmoviles.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseUser
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthManager
import com.mobileapplication.proyectoaplicacionesmoviles.screens.ContentDetailsScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.HomeScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.LoginScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.SignUpScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.WelcomeScreen


@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    val authManager: AuthManager = AuthManager(context)
    val user: FirebaseUser? = authManager.getCurrentUser()

    val startDestination = if (user != null) TabBar else Welcome

    NavHost(navController = navController, startDestination = startDestination) {
        composable<Welcome> {
            WelcomeScreen(
                navigateToLogin = { navController.navigate(Login) },
                navigateToSignUp = { navController.navigate(SignUp) }
            )
        }
        composable<Login> {
            LoginScreen(navigateToHome = { navController.navigate(TabBar) }, auth = authManager)
        }
        composable<SignUp> {
            SignUpScreen(auth = authManager)
        }
        composable<ContentDetails> {
            ContentDetailsScreen()
        }
        composable<TabBar> {
            TabBar(navController)
        }

    }
}
