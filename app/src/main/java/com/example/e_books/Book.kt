package com.example.e_books

import com.example.e_books.screens.sumary

class Book(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    val pages: Int,
    val sumary: String,
    val rating: Double
)

// Funcție fictivă pentru a obține lista de cărți
fun getBooks(): List<Book> {
    return listOf(
        Book(1, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1, sumary, 4.26),
        Book(2, "Pride and Prejudice", "Jane Austen", "Mystery", 1, sumary, 4.29),
        Book(3, "The Diary of a Young Girl", "Anne Frank", "Non-Fiction", 1, sumary, 4.19),
        Book(4, "Harry Potter and the Sorcerer’s Stone (Harry Potter, #1)", "J.K. Rowling", "Fiction", 1, sumary, 4.47),
        Book(5, "Animal Farm", "George Orwell", "Science Fiction", 1, sumary, 3.99)
    )
}