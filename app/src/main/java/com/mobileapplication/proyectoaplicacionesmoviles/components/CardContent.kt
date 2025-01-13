package com.mobileapplication.proyectoaplicacionesmoviles.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Composable
fun CardContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.height(80.dp).width(140.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp)) // Changed to rounded rectangle
                .border(border = BorderStroke(1.dp, BlueSecondary), shape = RoundedCornerShape(8.dp)) // Changed to rounded rectangle
            ,
            contentAlignment = Alignment.Center
        ) {
        }
    }
}
