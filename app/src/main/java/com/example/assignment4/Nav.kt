package com.example.assignment4

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(modifier: Modifier, navController: NavHostController) {
    NavHost(navController, startDestination = "RestaurantListScreen", modifier) {
        composable(route = "RestaurantListScreen") { RestaurantListScreen(modifier) }
        composable(route = "AddRestaurantScreen") { AddRestaurantScreen(modifier) }
    }
}