package com.example.e_books.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_books.R
import com.example.e_books.viewmodel.AuthState
import com.example.e_books.viewmodel.AuthViewModel

@Composable
fun LogInScreen(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    
    var pass by remember {
        mutableStateOf("")
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.isAuth -> navController.navigate("home_screen")
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = email,
                    onValueChange = {email = it},
                    label = { Text(text = "Email")}
                )
                TextField(
                    value = pass,
                    onValueChange = {pass = it},
                    label = { Text(text = "Password")}
                )
                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = { authViewModel.login(email, pass) }) {
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
    }
}