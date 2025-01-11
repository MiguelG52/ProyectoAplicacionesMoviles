package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.navigation.TabBar
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.ProyectoAplicacionesMovilesTheme

@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        UserProfileSection()
        EmotionScoresSection()
        EvaluationHistorySection()
    }
}

@Composable
fun UserProfileSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.user),
            contentDescription = "Perfil",
            modifier = Modifier.size(32.dp),
            tint = BlueSecondary
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(text = "Nombre Usuario", style = MaterialTheme.typography.titleMedium)
            Text(text = "usuario@example.com", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun EmotionScore(text: String, icon: Painter){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Image(painter = icon, contentDescription = text, modifier = Modifier.size(48.dp))
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left,
            color = BlueSecondary,
            fontSize = 8.sp,
        )
    }
}


@Composable
fun EmotionGraph() {


    val aaChartModel = AAChartModel()
        .chartType(AAChartType.Polygon)
        .backgroundColor("#FFFFFF")
        .dataLabelsEnabled(true)
        .series(arrayOf(
            AASeriesElement()
                .name("Emociones")
                .data(arrayOf(1, 2, 3, 4, 5))
        ))

    Spacer(modifier = Modifier.size(16.dp))
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        factory = {context ->
            AAChartView(context).apply {
                aa_drawChartWithChartModel(aaChartModel)
            }
        }
    )
}


@Composable
fun EmotionScoresSection() {
    SectionTitle(text = "Puntuajes de emocion")
    Spacer(modifier = Modifier.size(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        EmotionScore("Ansiedad", painterResource(id = R.drawable.icon_ansiedad))
        EmotionScore("Estrés", painterResource(id = R.drawable.icon_estres))
        EmotionScore("Irritabilidad", painterResource(id = R.drawable.icon_irritabilidad))
        EmotionScore("Depresión", painterResource(id = R.drawable.icon_depreseion))
        EmotionScore("Inseguridad", painterResource(id = R.drawable.icon_inseguridad))
    }
    EmotionGraph()
}



@Composable
fun EvaluationHistorySection() {
    SectionTitle(text = "Historial de Evaluaciones")
    LazyColumn {
        items(3) {
            Text(
                text = "2023-10-29: Completado",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(4.dp).fillMaxWidth(),
                textAlign = TextAlign.Left,
                color = BlueSecondary
            )
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Left,
        color = BlueSecondary
    )
}
