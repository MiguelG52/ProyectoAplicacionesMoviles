package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.Input
import com.mobileapplication.proyectoaplicacionesmoviles.components.PrimaryButton
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthManager


@Preview
@Composable
fun SignUpScreen(auth: AuthManager) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp), Arrangement.Center
    ){
        SignUpHeader()
        Spacer(modifier = Modifier.size(16.dp))
        SignUpForm()
    }
}
@Composable
fun SignUpHeader(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crea una cuenta",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = BlueSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.profesional),
            contentDescription = "Imagen de bienvenida",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Inicia tu camino a una mejor salud mental!",
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun SignUpForm(){
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isNameValid by remember { mutableStateOf(true) }
    val isBirthDateValid by remember { mutableStateOf(true) }
    val isEmailValid by remember { mutableStateOf(true) }
    val isPasswordValid by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Input(value = name, onValueChange = { name = it }, name = "Name", type = "text", placeholder = "Ingresa tu nombre", icon = painterResource(id = R.drawable.wing))
        if (!isNameValid) Text("El nombre es obligatorio", color = Color.Red)
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = birthDate, onValueChange = { birthDate = it }, name = "Fecha de Nacimiento", type = "date", placeholder = "Ingresa tu fecha de nacimiento", icon = painterResource(id = R.drawable.icon_calendario_morado))
        if (!isBirthDateValid) Text("La fecha de nacimiento es obligatoria", color = Color.Red)
        Spacer(modifier = Modifier.size(16.dp))

        Input( value = email, onValueChange = { email = it }, name = "Email", type = "text", placeholder = "Ingresa tu email", icon = painterResource(id = R.drawable.email))
        if (!isEmailValid) Text("Ingresa un email válido", color = Color.Red)
        Spacer(modifier = Modifier.size(16.dp))

        Input( value = password, onValueChange = { password = it }, name = "Contraseña", type = "password", placeholder = "Ingresa tu email", icon = painterResource(id = R.drawable.lock))
        if (!isPasswordValid) Text("La contraseña debe tener al menos 6 caracteres", color = Color.Red)
        Spacer(modifier = Modifier.size(26.dp))

        PrimaryButton(text = "Crear cuenta", onClick = {
            if (isNameValid && isBirthDateValid && isEmailValid && isPasswordValid) {
                onSignUp(name, birthDate, email, password) { success, message ->
                    if (success) {
                        Toast.makeText(context, "Cuenta creada exitosamente", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}

private fun onSignUp(
    name: String,
    birthDate: String,
    email: String,
    password: String,
    onResult: (Boolean, String) -> Unit
){
    val auth = FirebaseAuth.getInstance()
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onResult(true, "Cuenta creada")
            } else {
                val exception = task.exception
                val message = when (exception) {
                    is FirebaseAuthWeakPasswordException -> "Contraseña débil"
                    is FirebaseAuthInvalidCredentialsException -> "Credenciales inválidas"
                    is FirebaseAuthUserCollisionException -> "El email ya está en uso"
                    else -> "Error al crear la cuenta"
                }
                onResult(false, message)
            }
        }
}
