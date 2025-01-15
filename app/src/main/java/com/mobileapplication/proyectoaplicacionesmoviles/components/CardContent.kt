package com.mobileapplication.proyectoaplicacionesmoviles.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.mobileapplication.proyectoaplicacionesmoviles.models.Content
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary

@Composable
fun CardContent(navigate: () -> Unit, content: Content) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { navigate() }
    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .width(140.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(border = BorderStroke(1.dp, BlueSecondary), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(content.img),
                contentDescription = content.name,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = content.name,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(140.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis // Manejar el desbordamiento del texto
        )
    }
}
