package com.mobileapplication.proyectoaplicacionesmoviles.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RadioButtonGroup(selectedOption: Int?, onOptionSelected: (Int) -> Unit) {
    val options = listOf("Nunca", "Casi nunca", "Ocasionalmente", "Frecuentemente", "Siempre")
    options.forEachIndexed { index, option ->
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, ) {
            RadioButton(
                selected = (selectedOption == index),
                onClick = { onOptionSelected(index) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = option, fontSize = 16.sp, fontWeight = FontWeight.Light)
        }
    }
}