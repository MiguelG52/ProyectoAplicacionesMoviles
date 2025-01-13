package com.mobileapplication.proyectoaplicacionesmoviles.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobileapplication.proyectoaplicacionesmoviles.components.QuestionCard
import com.mobileapplication.proyectoaplicacionesmoviles.data.cuestionario

@Preview
@Composable
fun TestScreen(){

    var currentStep by remember { mutableIntStateOf(0) }
    val stepSize = 5
    val steps = (cuestionario.size + stepSize - 1) / stepSize

    Column(modifier = Modifier.padding(8.dp)) {

        val currentQuestions = cuestionario.drop(currentStep * stepSize).take(stepSize)

        for (question in currentQuestions) {
            QuestionCard(question = question)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (currentStep > 0) {
                Button(onClick = { currentStep-- }) {
                    Text(text = "Anterior")
                }
            }
            if (currentStep < steps - 1) {
                Button(onClick = { currentStep++ }) {
                    Text(text = "Siguiente")
                }
            } else {
                Button(onClick = {  }) {
                    Text(text = "Finalizar")
                }
            }
        }
    }
}


