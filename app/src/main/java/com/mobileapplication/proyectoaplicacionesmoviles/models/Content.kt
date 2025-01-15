package com.mobileapplication.proyectoaplicacionesmoviles.models

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val id: String = "",
    val name: String = "",
    val type: String = "",
    val img: String = "",
    val description: String = ""
)