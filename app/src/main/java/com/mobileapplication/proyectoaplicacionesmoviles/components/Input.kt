package com.mobileapplication.proyectoaplicacionesmoviles.components



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.Gray


@Composable
fun Input(value:String,name: String, type: String, placeholder: String, icon: Painter?, onValueChange: (String) -> Unit) {
    Column {
        Text(text = name,fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.size(8.dp))
        if (type == "date") {
            PrimaryDatePicker(placeholder = placeholder, icon = icon)
        } else {
            PrimaryTextField(placeholder = placeholder, icon = icon, isPassword = type == "password", value = value, onValueChange = onValueChange )
        }
    }
}

@Composable
fun PrimaryTextField(value: String, onValueChange: (String) -> Unit, placeholder: String, icon: Painter?, isPassword: Boolean = false){

    OutlinedTextField(
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        shape = RoundedCornerShape(30.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedPlaceholderColor = Gray,
            unfocusedPlaceholderColor = Gray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            cursorColor = BlueSecondary,
            unfocusedBorderColor = BlueSecondary),
        trailingIcon = {
            icon?.let {
                Icon(painter = it, contentDescription = null, tint = BlueSecondary)
            }},
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth())
}