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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.e_books.Book
import com.example.e_books.BottomNavigationItem
import com.example.e_books.Content
import com.example.e_books.R
import com.example.e_books.books
import com.example.e_books.getBooks

@Composable
fun BooksScreen(navController: NavController) {
    Content(navController, { BooksContent(navController) })
}

@Composable
fun BooksContent(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedGenre by remember { mutableStateOf<String?>(null) }
    val genres = listOf("Fiction", "Non-Fiction", "Mystery", "Fantasy", "Science Fiction")
    val books = getBooks()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier.padding(end = 8.dp)
                )
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    decorationBox = { innerTextField ->
                        Box(Modifier.padding(8.dp)) {
                            innerTextField()
                        }
                    }
                )
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            genres.forEach { genre ->
                item{
                    Button(
                        onClick = {
                            selectedGenre = if (selectedGenre == genre) null else genre
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedGenre == genre) Color.Gray else Color.LightGray
                        )
                    ) {
                        Text(
                            text = genre,
                            color = Color.Black
                        )
                    }
                }
            }
        }

        LazyColumn {
            val filteredBooks = books.filter { book ->
                (selectedGenre == null || book.category == selectedGenre) &&
                        (searchQuery.isEmpty() || book.title.contains(searchQuery, ignoreCase = true))
            }
            items(filteredBooks) { book ->
                BookItem(navController = navController, book = book)
            }
        }
    }
}