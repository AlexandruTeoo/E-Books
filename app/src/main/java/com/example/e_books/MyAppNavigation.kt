package com.example.e_books

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_books.screens.BooksScreen
import com.example.e_books.screens.HomeScreen
import com.example.e_books.screens.LogInScreen
import com.example.e_books.screens.ProfileScreen
import com.example.e_books.screens.SavedScreen
import com.example.e_books.screens.SignUpScreen

@Composable
fun MyAppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_screen"
    ){
        composable("login_screen"){
            LogInScreen(navController)
        }
        composable("signup_screen"){
            SignUpScreen(navController)
        }
        composable("home_screen"){
            HomeScreen(navController)
        }
        composable("books_screen"){
            BooksScreen(navController)
        }
        composable("saved_screen"){
            SavedScreen(navController)
        }
        composable("profile_screen"){
            ProfileScreen(navController)
        }
    }
}