package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.data.ProfileRepository
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val repository = ProfileRepository(context)

    var name by remember { mutableStateOf(repository.getRestaurantName()) }
    var address by remember { mutableStateOf(repository.getAddress()) }
    var description by remember { mutableStateOf(repository.getDescription()) }
    var openHours by remember { mutableStateOf(repository.getOpenHours()) }

    val boldYellow = Color(0xFFFFD600)
    val darkCharcoal = Color(0xFF121212)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EDIT BRAND", fontWeight = FontWeight.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
                .padding(32.dp)
        ) {
            TrendyTextField(value = name, onValueChange = { name = it }, label = "Brand Name")
            Spacer(modifier = Modifier.height(24.dp))
            TrendyTextField(value = address, onValueChange = { address = it }, label = "Outlet Address")
            Spacer(modifier = Modifier.height(24.dp))
            TrendyTextField(value = description, onValueChange = { description = it }, label = "Brand Story", singleLine = false)
            Spacer(modifier = Modifier.height(24.dp))
            TrendyTextField(value = openHours, onValueChange = { openHours = it }, label = "Opening Hours")

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    repository.saveProfile(name, address, description, openHours)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = darkCharcoal)
            ) {
                Text("SAVE BRAND INFO", fontWeight = FontWeight.Black, color = boldYellow)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            TextButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("CANCEL CHANGES", color = Color.Gray, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun TrendyTextField(value: String, onValueChange: (String) -> Unit, label: String, singleLine: Boolean = true) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, fontWeight = FontWeight.Bold) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        ),
        singleLine = singleLine
    )
}
