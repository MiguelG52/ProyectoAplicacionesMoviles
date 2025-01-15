package com.mobileapplication.proyectoaplicacionesmoviles.navigation

import com.mobileapplication.proyectoaplicacionesmoviles.models.Content
import kotlinx.serialization.Serializable

@Serializable
object Welcome
@Serializable
object About
@Serializable
object Login
@Serializable
object Profile
@Serializable
object SignUp
@Serializable
object Home
@Serializable
object TabBar
@Serializable
data class ContentDetails(val date: List<Content>)

