package com.mobileapplication.proyectoaplicacionesmoviles.components

import android.util.Log
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
        onClick = {
            try {
                onClick()
            } catch (e: Exception) {
                // Manejar el error apropiadamente
                Log.e("PrimaryButton", "Error on button click", e)
            }

        },
        modifier = modifier.fillMaxWidth().height(55.dp),
        colors = ButtonDefaults.buttonColors(BlueSecondary)
    ) {
        Text(text = text)
    }
}