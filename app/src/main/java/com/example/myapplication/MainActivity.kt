package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // TRENDY URBAN SCHEME: Bold Yellow, Dark Charcoal, White
        val trendyBakmiScheme = lightColorScheme(
            primary = Color(0xFFFFD600), // Bold Yellow
            onPrimary = Color.Black,
            primaryContainer = Color(0xFFFFF176),
            onPrimaryContainer = Color.Black,
            secondary = Color(0xFF212121), // Charcoal
            onSecondary = Color.White,
            background = Color.White,
            surface = Color.White,
            onSurface = Color.Black,
            surfaceVariant = Color(0xFFEEEEEE)
        )

        setContent {
            MaterialTheme(colorScheme = trendyBakmiScheme) {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    bottomBar = {
                        if (currentDestination?.route in listOf("home", "menu", "profile")) {
                            NavigationBar(
                                containerColor = Color.Black,
                                tonalElevation = 0.dp
                            ) {
                                NavigationBarItem(
                                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                                    label = { Text("Home") },
                                    selected = currentDestination?.hierarchy?.any { it.route == "home" } == true,
                                    onClick = {
                                        navController.navigate("home") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color(0xFFFFD600),
                                        selectedTextColor = Color(0xFFFFD600),
                                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                                        indicatorColor = Color.Transparent
                                    )
                                )
                                NavigationBarItem(
                                    icon = { Icon(Icons.Default.Menu, contentDescription = null) },
                                    label = { Text("Explore") },
                                    selected = currentDestination?.hierarchy?.any { it.route == "menu" } == true,
                                    onClick = {
                                        navController.navigate("menu") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color(0xFFFFD600),
                                        selectedTextColor = Color(0xFFFFD600),
                                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                                        indicatorColor = Color.Transparent
                                    )
                                )
                                NavigationBarItem(
                                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                                    label = { Text("Brand") },
                                    selected = currentDestination?.hierarchy?.any { it.route == "profile" } == true,
                                    onClick = {
                                        navController.navigate("profile") {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color(0xFFFFD600),
                                        selectedTextColor = Color(0xFFFFD600),
                                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                                        indicatorColor = Color.Transparent
                                    )
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable("home") { HomeScreen(navController) }
                            composable("menu") { MenuScreen(navController) }
                            composable(
                                "detail/{menuId}",
                                arguments = listOf(navArgument("menuId") { type = androidx.navigation.NavType.StringType })
                            ) { backStackEntry ->
                                val menuId = backStackEntry.arguments?.getString("menuId") ?: ""
                                DetailMenuScreen(navController, menuId)
                            }
                            composable("profile") { ProfileScreen(navController) }
                            composable("edit_profile") { EditProfileScreen(navController) }
                        }
                    }
                }
            }
        }
    }
}
