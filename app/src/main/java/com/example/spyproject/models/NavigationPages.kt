package com.example.spyproject.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationItem(var rout: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object Players : NavigationItem("players", Icons.Default.Person, "Players")
    object Places : NavigationItem("places", Icons.Default.Place, "Places")
    object About : NavigationItem("about", Icons.Default.Place, "About")
}

