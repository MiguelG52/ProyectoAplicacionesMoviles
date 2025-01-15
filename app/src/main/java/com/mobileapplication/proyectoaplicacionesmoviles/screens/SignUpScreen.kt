package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.content.Context
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.components.Input
import com.mobileapplication.proyectoaplicacionesmoviles.components.PrimaryButton
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import androidx.compose.ui.platform.LocalContext
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthManager
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthRes
import kotlinx.coroutines.launch


@Composable
fun SignUpScreen(auth: AuthManager) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp), Arrangement.Center
    ){
        SignUpHeader()
        Spacer(modifier = Modifier.size(16.dp))
        SignUpForm( auth = auth)
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
fun SignUpForm(auth: AuthManager){
    var name by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isNameValid by remember { mutableStateOf(true) }
    val isBirthDateValid by remember { mutableStateOf(true) }
    val isEmailValid by remember { mutableStateOf(true) }
    val isPasswordValid by remember { mutableStateOf(true) }
    val scope  = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Input(value = name, onValueChange = { name = it }, name = "Name", type = "text", placeholder = "Ingresa tu nombre", icon = painterResource(id = R.drawable.wing))
        if (!isNameValid) Text("El nombre es obligatorio", color = Color.Red)
        Spacer(modifier = Modifier.size(16.dp))

        Input(value = birthday, onValueChange = { birthday = it }, name = "Fecha de Nacimiento", type = "date", placeholder = "Ingresa tu fecha de nacimiento", icon = painterResource(id = R.drawable.icon_calendario_morado))
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
                scope.launch {
                    onSignUp(name, birthday, email, password, auth = auth, context)
                }
            }
        })
    }
}

private suspend fun onSignUp(
    name: String,
    birthday: String,
    email: String,
    password: String,
    auth: AuthManager,
    context: Context
) {
    if(email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
        when (val result = auth.createUserWithEmailAndPassword(email, password, name, birthday)) {
            is AuthRes.Success -> {
            Toast.makeText(context, "Se ha creado el usuario correctamente", Toast.LENGTH_LONG).show()
        }
            is AuthRes.Error -> {
            Toast.makeText(context, "Ocurrio un error al crear el usuario: ${result.errorMessage}", Toast.LENGTH_LONG).show()
        }
        }
    } else {
        Toast.makeText(context, "Existen campos vacios", Toast.LENGTH_SHORT).show()
    }
}
