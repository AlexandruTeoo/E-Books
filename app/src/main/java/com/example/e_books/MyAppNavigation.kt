package com.example.e_books

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_books.screens.BookDetailsScreen
import com.example.e_books.screens.BooksScreen
import com.example.e_books.screens.HomeScreen
import com.example.e_books.screens.LogInScreen
import com.example.e_books.screens.ProfileScreen
import com.example.e_books.screens.SavedScreen
import com.example.e_books.screens.SignUpScreen
import com.example.e_books.screens.sumary
import com.example.e_books.viewmodel.AuthViewModel

sealed class Screens(val route: String) {
    object Home : Screens("home_screen")
    object BookDetails : Screens("book_details_screen/{bookId}") {
        fun createRoute(bookId: Int) = "book_details_screen/$bookId"
    }
}

val books = listOf(
    Book(1, "To Kill a Mockingbird", "Harper Lee", "1", 1, sumary, 4.26),
    Book(2, "Pride and Prejudice", "Jane Austen", "1", 1, sumary, 4.29),
    Book(3, "The Diary of a Young Girl", "Anne Frank", "2", 1, sumary, 4.19),
    Book(4, "Harry Potter and the Sorcerer’s Stone (Harry Potter, #1)", "J.K. Rowling", "4", 1, sumary, 4.47),
    Book(5, "Animal Farm", "George Orwell", "3", 1, sumary, 3.99)
)

@Composable
fun MyAppNavigation(authViewModel: AuthViewModel){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_screen"
    ){
        composable("login_screen"){
            LogInScreen(navController, authViewModel)
        }
        composable("signup_screen"){
            SignUpScreen(navController, authViewModel)
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
            ProfileScreen(navController, authViewModel)
        }
        composable(Screens.BookDetails.route) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId")?.toInt()
            val book = books.first { it.id == bookId }
            BookDetailsScreen(navController, book)
        }
    }
}