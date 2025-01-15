package com.mobileapplication.proyectoaplicacionesmoviles.firebase

import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await
import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore


sealed class AuthRes<out T> {
    data class Success<T>(val data: T): AuthRes<T>()
    data class Error(val errorMessage: String): AuthRes<Nothing>()
}
class AuthManager(private val context: Context) {
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    private val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }


    suspend fun createUserWithEmailAndPassword(email: String, password: String, name: String, birthDate: String): AuthRes<FirebaseUser?> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user

            user?.let {
                val userData = mapOf(
                    "name" to name,
                    "birthDate" to birthDate,
                    "email" to email
                )
                firestore.collection("usuarios").document(user.uid).set(userData).await()
            }

            AuthRes.Success(user)
        } catch(e: Exception) {
            AuthRes.Error(e.message ?: "Error al crear el usuario")
        }
    }

    suspend fun signInWithEmailAndPassword(email: String, password: String): AuthRes<FirebaseUser?> {
        return try {
            val authResult = auth.signInWithEmailAndPassword(email, password).await()
            AuthRes.Success(authResult.user)
        } catch(e: Exception) {
            AuthRes.Error(e.message ?: "Error al iniciar sesión")
        }
    }

    fun getCurrentUser(): FirebaseUser?{
        return auth.currentUser
    }

}