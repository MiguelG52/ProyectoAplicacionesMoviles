package com.mobileapplication.proyectoaplicacionesmoviles.firebase


import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await
import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.mobileapplication.proyectoaplicacionesmoviles.models.Content
import com.mobileapplication.proyectoaplicacionesmoviles.models.Test
import com.mobileapplication.proyectoaplicacionesmoviles.models.User


sealed class AuthRes<out T> {
    data class Success<T>(val data: T): AuthRes<T>()
    data class Error(val errorMessage: String): AuthRes<Nothing>()
}
class AuthManager(private val context: Context) {
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    private val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }


    suspend fun createUserWithEmailAndPassword(email: String, password: String, name: String, birthday: String): AuthRes<FirebaseUser?> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user

            user?.let {
                val userData = mapOf(
                    "name" to name,
                    "birtday" to birthday,
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
    suspend fun fetchTestsByID(userId: String): List<Test> {
        return try {
            val snapshot = firestore.collection("tests").get().await()
            snapshot.documents.map { document ->
                Test(
                    scores = document.get("scores") as Map<String, Int>? ?: emptyMap(),
                )
            }
        } catch (e: Exception) {
            emptyList() // Devuelve una lista vacía si hay un error
        }
    }

    suspend fun fetchUserData(userId: String): User? {
        return try {
            val documentSnapshot = firestore.collection("usuarios").document(userId).get().await()
            val user = documentSnapshot.toObject(User::class.java)
            user?.apply {
                id = documentSnapshot.getString("id") ?: ""
            }
            user
        } catch (e: Exception) {
            null
        }
    }


    suspend fun fetchVideos(): List<Content> {
        return try {
            val snapshot = firestore.collection("videos").get().await()
            snapshot.documents.mapNotNull { doc ->
                doc.toObject(Content::class.java)?.copy(id = doc.id)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    suspend fun fetchRecetas(): List<Content> {
        return try {
            val snapshot = firestore.collection("recetas").get().await()
            snapshot.documents.mapNotNull { doc ->
                doc.toObject(Content::class.java)?.copy(id = doc.id)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    suspend fun fetchLibros(): List<Content> {
        return try {
            val snapshot = firestore.collection("libros").get().await()
            snapshot.documents.mapNotNull { doc ->
                doc.toObject(Content::class.java)?.copy(id = doc.id)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    suspend fun fetchEjercicios(): List<Content> {
        return try {
            val snapshot = firestore.collection("ejercicios").get().await()
            snapshot.documents.mapNotNull { doc ->
                doc.toObject(Content::class.java)?.copy(id = doc.id)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }


}