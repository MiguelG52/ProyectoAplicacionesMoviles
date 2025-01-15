package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.google.firebase.auth.FirebaseUser
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.firebase.AuthManager
import com.mobileapplication.proyectoaplicacionesmoviles.models.Test
import com.mobileapplication.proyectoaplicacionesmoviles.models.User
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Composable
fun ProfileScreen(authManager: AuthManager) {
    var tests by remember { mutableStateOf<List<Test>>(emptyList()) }

    var currentUser by remember { mutableStateOf<FirebaseUser?>(null) }
    var userData by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(Unit) {



        currentUser = authManager.getCurrentUser()
        currentUser?.uid?.let {
            userData = authManager.fetchUserData(it)
        }
        currentUser?.uid?.let {
            userData = authManager.fetchUserData(it)
        }
        Log.d("user", "user: $userData")


        tests = authManager.fetchTestsByID("hola")
        Log.d("profile", "tests: $tests")

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        UserProfileSection(userData)
        Spacer(modifier = Modifier.size(16.dp))
        EmotionScoresSection()
        Spacer(modifier = Modifier.size(16.dp))
        EvaluationHistorySection(tests)
    }
}

@Composable
fun UserProfileSection(user: User?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(border = BorderStroke(1.dp, Color.White), shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
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
            Text(
                text = user?.name ?: "Nombre Usuario",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = user?.email ?: "usuario@example.com",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun EmotionScore(text: String, icon: Painter) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
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
fun EmotionPieChart() {
    // Configuración del modelo de la gráfica circular
    Image(painter = painterResource(R.drawable.grafica), contentDescription = "Grafica",
        modifier = Modifier.fillMaxWidth().height(300.dp))
    /**
    val aaChartModel = AAChartModel()
        .chartType(AAChartType.Pie)
        .backgroundColor("#FFFFFF")
        .dataLabelsEnabled(true)
        .series(
            arrayOf(
                AASeriesElement()
                    .name("Emociones")
                    .data(
                        arrayOf(
                            arrayOf("Felicidad", 25),
                            arrayOf("Tristeza", 20),
                            arrayOf("Miedo", 15),
                            arrayOf("Ira", 30),
                            arrayOf("Sorpresa", 10)
                        )
                    )
            )
        )
        .colorsTheme(arrayOf("#FFC107", "#2196F3", "#4CAF50", "#F44336", "#9C27B0"))

    Spacer(modifier = Modifier.size(16.dp))
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        factory = { context ->
            AAChartView(context).apply {
                aa_drawChartWithChartModel(aaChartModel)
            }
        }
    )
    */
}

@Composable
fun EmotionScoresSection() {
    Column(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(border = BorderStroke(1.dp, Color.White), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        SectionTitle(text = "Puntuajes de Emoción")
        Spacer(modifier = Modifier.size(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            EmotionScore("Ansiedad", painterResource(id = R.drawable.icon_ansiedad))
            EmotionScore("Estres", painterResource(id = R.drawable.icon_estres))
            EmotionScore("Irritabilidad", painterResource(id = R.drawable.icon_irritabilidad))
            EmotionScore("Depresión", painterResource(id = R.drawable.icon_depreseion))
            EmotionScore("Inseguridad", painterResource(id = R.drawable.icon_inseguridad))
        }
        Spacer(modifier = Modifier.size(16.dp))
        EmotionPieChart() // Llamada a la gráfica circular
    }
}

@Composable
fun EvaluationHistorySection(tests: List<Test>) {
    Column(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(border = BorderStroke(1.dp, Color.White), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        SectionTitle(text = "Historial de Evaluaciones")
        tests.forEach { test ->
            Text(
                text = ": Completado",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
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
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Left,
        color = BlueSecondary
    )
}