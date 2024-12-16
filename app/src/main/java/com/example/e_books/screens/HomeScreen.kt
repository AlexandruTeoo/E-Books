package com.example.e_books.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.e_books.Book
import com.example.e_books.BottomNavigationItem
import com.example.e_books.Content
import com.example.e_books.Screens

val sumary = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sed neque sed tortor porttitor fermentum vel eget nisl. Aliquam nec laoreet velit, bibendum dapibus turpis. Vestibulum in mauris libero. Curabitur sodales vel dolor vitae lobortis. Etiam a porttitor eros. Sed sed sagittis ligula. Donec elit ex, semper ultricies neque at, ornare ultricies neque. Maecenas elementum ante eget mi tincidunt porta. Praesent mollis, ligula vitae tempus malesuada, nisi augue dignissim felis, eget luctus dolor enim tempus dui. Nulla non fermentum sapien. Vivamus libero tortor, aliquet gravida semper ac, efficitur vel ante. Proin at libero sed nibh lacinia tristique. Morbi molestie dolor vel elementum blandit. Integer non neque id sem efficitur bibendum vitae et purus. Aliquam feugiat lobortis massa, sodales sodales urna congue eu.\n" +
        "\n" +
        "Aliquam molestie gravida nisi, nec fringilla dolor pulvinar sed. Duis semper suscipit quam sit amet accumsan. Morbi id nibh id enim dignissim luctus maximus ac justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vestibulum, diam a pellentesque mattis, eros dui congue felis, sed tincidunt odio dolor et tortor. Integer ultricies libero eu nibh ornare suscipit. Cras at tincidunt purus."

val recommendedBooks = listOf(
    Book(1, "To Kill a Mockingbird", "Harper Lee", "1", 1, sumary, 4.26),
    Book(2, "Pride and Prejudice", "Jane Austen", "1", 1, sumary, 4.29),
    Book(3, "The Diary of a Young Girl", "Anne Frank", "2", 1, sumary, 4.19),
    Book(4, "Harry Potter and the Sorcerer’s Stone (Harry Potter, #1)", "J.K. Rowling", "4", 1, sumary, 4.47),
    Book(5, "Animal Farm", "George Orwell", "3", 1, sumary, 3.99)
)

val bestSellers = listOf(
    Book(1, "To Kill a Mockingbird", "Harper Lee", "1", 1, " ", 4.26),
    Book(2, "Pride and Prejudice", "Jane Austen", "1", 1, "", 4.29),
    Book(3, "The Diary of a Young Girl", "Anne Frank", "2", 1, "", 4.19)
)

@Composable
fun HomeScreen(navController: NavController) {
    Content(navController = navController, contentToDisplay = { HomeContent(navController) })
}

@Composable
fun HomeContent(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Currently Reading")
        // Add current reading book content here

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Recommended", style = MaterialTheme.typography.headlineMedium)
        LazyRow(
            modifier = Modifier
                .background(Color.DarkGray)
        ) {
            items(recommendedBooks) { book ->
                BookItem(book, navController)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Best Sellers", style = MaterialTheme.typography.headlineMedium)
        LazyRow {
            items(bestSellers) { book ->
                BookItem(book, navController = navController)
            }
        }
    }
}

@Composable
fun BookItem(book: Book, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                navController.navigate(Screens.BookDetails.createRoute(book.id))
            }
    ) {
        Column {
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "by ${book.author}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
        }
    }
}