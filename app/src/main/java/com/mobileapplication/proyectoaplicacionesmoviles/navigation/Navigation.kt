package com.mobileapplication.proyectoaplicacionesmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobileapplication.proyectoaplicacionesmoviles.screens.ContentDetailsScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.LoginScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.SignUpScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.WelcomeScreen
import com.mobileapplication.proyectoaplicacionesmoviles.navigation.TabBar


@Composable
fun Navigation(){
   val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Welcome) {
       composable<Welcome>{
           WelcomeScreen(navigateToLogin = {navController.navigate(Login)}, navigateToSignUp = {navController.navigate(SignUp)})
       }
       composable<Login> { LoginScreen(navigateToHome = { navController.navigate(TabBar)})  }
       composable<SignUp> { SignUpScreen()}
        composable<TabBar>{ TabBar() }
    }
}