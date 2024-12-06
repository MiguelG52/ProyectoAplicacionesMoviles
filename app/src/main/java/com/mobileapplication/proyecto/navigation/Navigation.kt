package com.mobileapplication.proyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mobileapplication.proyecto.views.DetailsScreen
import com.mobileapplication.proyecto.views.HomeScreen
import com.mobileapplication.proyecto.views.LoginScreen
import com.mobileapplication.proyecto.views.SignUpScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToHome = { navController.navigate(TabBar) }, navigateToSignUp = { navController.navigate(SignUp) })
        }
        composable<SignUp>{
            SignUpScreen()
        }

        composable<TabBar>{
            TabBar(navController)
        }
        composable<Home> {
            HomeScreen (navigateToDetails = { content ->
                navController.navigate("details/$content")
            })
        }
        composable(
            route = "details/{content}",
            arguments = listOf(navArgument("content") { type = NavType.StringType })
        ) { backStackEntry ->
            val content = backStackEntry.arguments?.getString("content") ?: ""
            DetailsScreen(content = content)
        }

    }
}
