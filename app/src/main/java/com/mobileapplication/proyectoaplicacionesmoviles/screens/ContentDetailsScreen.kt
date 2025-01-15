package com.mobileapplication.proyectoaplicacionesmoviles.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.models.Content
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.GraySecondary
import kotlinx.serialization.json.Json


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentDetailsScreen(contentJson: String?){
    val content = contentJson?.let { Json.decodeFromString<Content>(it) }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {

            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = BlueSecondary,
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().background(Color.White)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_ios_downward_outline),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(end = 8.dp)
                        )
                        content?.let {
                            Text(
                                text = it.name,
                                fontWeight = FontWeight.SemiBold,
                                color = BlueSecondary,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }){
        content?.let {
            Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxHeight()
                    .background(GraySecondary).verticalScroll(
                        rememberScrollState()
                    )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(content.img),
                    contentDescription = content.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = it.description,
                    fontWeight = FontWeight.SemiBold,
                    color = BlueSecondary,
                    modifier = Modifier.weight(1f)
                )

            }

        }

    }
}
