package com.mobileapplication.proyectoaplicacionesmoviles.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapplication.proyectoaplicacionesmoviles.models.Question


@Composable
fun QuestionCard(question: Question) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    Column(
        modifier = Modifier.padding(4.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp)) // Changed to rounded rectangle
            .border(border = BorderStroke(1.dp, Color.White), shape = RoundedCornerShape(8.dp)) // Changed to rounded rectangle
        ,
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = question.pregunta, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            RadioButtonGroup(selectedOption) { selectedOption = it }
        }
    }
}

