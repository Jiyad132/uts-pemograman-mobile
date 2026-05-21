package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.myapplication.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen(navController: NavController) {
    val boldYellow = Color(0xFFFFD600)
    val darkCharcoal = Color(0xFF121212)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // TRENDY URBAN HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(darkCharcoal)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bakmi),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Surface(
                    color = boldYellow,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "LEVEL UP YOUR NOODLES",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Black,
                        color = Color.Black
                    )
                }
                
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Bakmi\nGemboel",
                    style = MaterialTheme.typography.displayLarge.copy(
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        lineHeight = 60.sp
                    )
                )
                
                Text(
                    "The Urban Noodle Movement",
                    style = MaterialTheme.typography.bodyLarge,
                    color = boldYellow,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // FEATURED "VIRAL" SECTION
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Viral Picks 🔥",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Black
                )
                Text(
                    "See All",
                    modifier = Modifier.clickable { navController.navigate("menu") },
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // Trendy Featured Item Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clickable { navController.navigate("menu") },
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = darkCharcoal)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.size(120.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.bakmi),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Signature Truffle", color = boldYellow, fontWeight = FontWeight.Black)
                        Text("Most Wanted Bowl", color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("IDR 55K", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // MODERN NAV BUTTONS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TrendyNavBox(
                    title = "EXPLORE\nMENU",
                    color = boldYellow,
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate("menu") }
                )
                TrendyNavBox(
                    title = "BRAND\nSTORY",
                    color = Color(0xFFEEEEEE),
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate("profile") }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun TrendyNavBox(title: String, color: Color, modifier: Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier
            .height(100.dp)
            .clickable { onClick() },
        color = color,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Black,
                lineHeight = 18.sp
            )
        }
    }
}
