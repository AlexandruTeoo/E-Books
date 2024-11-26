package com.example.e_books.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_books.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Page",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate("home_screen") }) {
                Image(
                    painter = painterResource(id = R.drawable.home_icon),
                    contentDescription = "Home"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { navController.navigate("books_screen") }) {
                Image(
                    painter = painterResource(id = R.drawable.library_icon),
                    contentDescription = "Books"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { navController.navigate("saved_screen") }) {
                Image(
                    painter = painterResource(id = R.drawable.save_icon),
                    contentDescription = "Saved"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { navController.navigate("profile_screen") }) {
                Image(
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Profile"
                )
            }
        }
    }
}