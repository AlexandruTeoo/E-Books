package com.example.e_books

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.e_books.screens.BooksContent

@Composable
fun Content(navController: NavController, contentToDisplay: @Composable () -> Unit) {
    val items = listOf(
        BottomNavigationItem(
            title = "home_screen",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            title = "books_screen",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List
        ),
        BottomNavigationItem(
            title = "saved_screen",
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star
        ),
        BottomNavigationItem(
            title = "profile_screen",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )

    // Observe the current route to update the selected item in BottomNavigation
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Find the index of the current route in the items list
    var selectedItemIndex = items.indexOfFirst { it.title == currentRoute }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.Gray
            ){
                items.forEachIndexed{ index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex){
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    ) { innerPading ->
        Box(
            modifier = Modifier
                .padding(innerPading)
        ){
            contentToDisplay()
        }
    }
}

