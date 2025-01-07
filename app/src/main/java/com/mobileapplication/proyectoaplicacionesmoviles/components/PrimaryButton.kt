package com.mobileapplication.proyectoaplicacionesmoviles.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(55.dp),
        colors = ButtonDefaults.buttonColors(BlueSecondary)
    ) {
        Text(text = text)
    }
}