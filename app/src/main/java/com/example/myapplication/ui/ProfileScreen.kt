package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.data.ProfileRepository
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.R
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val repository = ProfileRepository(context)
    val boldYellow = Color(0xFFFFD600)
    val darkCharcoal = Color(0xFF121212)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BRAND IDENTITY", fontWeight = FontWeight.Black, letterSpacing = 2.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            // TRENDY PROFILE HEADER
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(darkCharcoal)
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.size(150.dp),
                    shape = RoundedCornerShape(30.dp),
                    color = boldYellow
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bakmi),
                        contentDescription = "Logo",
                        modifier = Modifier.padding(20.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Column(
                modifier = Modifier.padding(32.dp)
            ) {
                Text(
                    text = repository.getRestaurantName(),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Black,
                    color = Color.Black
                )
                
                Surface(
                    color = boldYellow,
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        " URBAN STREET FOOD ",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.height(32.dp))

                TrendyInfoSection("THE MOVEMENT", repository.getDescription())
                TrendyInfoSection("OUTLET LOCATION", repository.getAddress())
                TrendyInfoSection("SERVICE HOURS", repository.getOpenHours())

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    onClick = { navController.navigate("edit_profile") },
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = darkCharcoal)
                ) {
                    Text("UPDATE BRAND INFO", fontWeight = FontWeight.Black, color = boldYellow)
                }
            }
        }
    }
}

@Composable
fun TrendyInfoSection(title: String, content: String) {
    Column(modifier = Modifier.padding(bottom = 24.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = Color.Gray,
            fontWeight = FontWeight.Black,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            lineHeight = 24.sp,
            textAlign = TextAlign.Justify
        )
    }
}
