package com.mobileapplication.proyectoaplicacionesmoviles.models

data class User(
    val name: String = "",
    val birthDate: String = "",
    val email: String = "",
    val tests: List<Test>? = null
)