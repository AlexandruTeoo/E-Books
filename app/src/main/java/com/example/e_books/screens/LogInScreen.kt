package com.example.e_books.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_books.R

@Composable
fun LogInScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Log In Page")
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = { navController.navigate("home_screen") }) {
            Text(text = "Log In")
        }
        Spacer(modifier = Modifier.height(6.dp))
        TextButton(onClick = { navController.navigate("signup_screen") }) {
            Text(text = "Don't have an account? Sign Up here!")
        }
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "Google logo"
            )
        }
    }
}