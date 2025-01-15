package com.mobileapplication.proyectoaplicacionesmoviles.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileapplication.proyectoaplicacionesmoviles.R
import com.mobileapplication.proyectoaplicacionesmoviles.screens.AboutScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.HomeScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.ProfileScreen
import com.mobileapplication.proyectoaplicacionesmoviles.screens.TestScreen
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.GraySecondary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBar(navController: NavHostController) {

    val tabs = listOf("Inicio", "Perfil", "Test", "Acerca De")
    val titles = listOf("Inicio", "Perfil", "Test", "Acerca De")

    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.AccountCircle,
        Icons.Filled.Add,
        Icons.Filled.Info
    )
    var selectedTabIndex by remember { mutableIntStateOf(0) }
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
                            painter = painterResource(id = R.drawable.isologo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(end = 8.dp)
                        )
                        Text(
                            text = titles[selectedTabIndex],
                            fontWeight = FontWeight.SemiBold,
                            color = BlueSecondary,
                            modifier = Modifier.weight(1f)
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = BlueSecondary
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = BlueSecondary,
                    contentColor = Color.White,
                ) {
                    tabs.forEachIndexed { index, tabName ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        imageVector = icons[index],
                                        contentDescription = tabName,
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = tabName,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
                .fillMaxHeight()
                .background(GraySecondary).verticalScroll(
                rememberScrollState()
            )
            ) {
            // Contenido de las pestañas
            when (selectedTabIndex) {
                0 -> HomeScreen(navController)
                1 -> ProfileScreen()
                2 -> TestScreen()
                3 -> AboutScreen()

            }
        }
    }
}