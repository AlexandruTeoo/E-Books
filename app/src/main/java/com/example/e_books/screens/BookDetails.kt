package com.example.e_books.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_books.Book

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun BookDetailsScreen (navController: NavController, book: Book){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Book Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {contentPadding  ->
            LazyColumn(
                modifier = Modifier
                    .padding(contentPadding )
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Text(text = book.title, style = MaterialTheme.typography.headlineLarge)
                }
                item {
                    Text(
                        text = "by ${book.author}",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                item {Spacer(modifier = Modifier.height(8.dp))}
                item {Text(text = "Category: ${book.category}", style = MaterialTheme.typography.bodyMedium)}
                item {Text(text = "Pages: ${book.pages}", style = MaterialTheme.typography.bodyMedium)}
                item {Text(text = "Rating: ${book.rating}/5", style = MaterialTheme.typography.bodyMedium)}
                item {Spacer(modifier = Modifier.height(8.dp))}
                item {Text(text = "Sumary:", style = MaterialTheme.typography.headlineMedium)}
                item {Text(text = book.sumary, style = MaterialTheme.typography.bodyMedium)}
            }
        }
    )
}
