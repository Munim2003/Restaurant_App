package com.example.assignment4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assignment4.ui.theme.Assignment4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment4Theme {
                val navItemsList = listOf(
                    MyNavItem(
                        title = "Restaurants",
                        iconSelected = Icons.Filled.Home,
                        iconUnselected = Icons.Outlined.Home,
                        route = "RestaurantListScreen"
                    ),
                    MyNavItem(
                        title = "Add Restaurant",
                        iconSelected = Icons.Filled.Add,
                        iconUnselected = Icons.Outlined.Add,
                        route = "AddRestaurantScreen"
                    ),
                )
                val navHostController = rememberNavController()
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination


                    Scaffold(
                        floatingActionButton = {MyFab(navHostController)},
                        topBar = { MyTopAppBar(navHostController) },
                            bottomBar = {
                                NavigationBar {
                                    navItemsList.forEach { item ->
                                        NavigationBarItem(
                                            selected = currentDestination?.route == item.route,
                                            onClick = {
                                                navHostController.navigate(item.route) {
                                                    launchSingleTop = true
                                                    restoreState = true
                                                    popUpTo(navHostController.graph.findStartDestination().id) {
                                                        saveState = false
                                                    }
                                                }
                                            },
                                            label = { Text(text = item.title) },
                                            icon = {
                                                Icon(
                                                    contentDescription = item.title,
                                                    imageVector = if (currentDestination?.route == item.route)
                                                        item.iconSelected
                                                    else
                                                        item.iconUnselected
                                                )
                                            }
                                        )
                                    }
                                }

                        }
                    ) {
                        innerPadding -> Nav(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding(), top = innerPadding.calculateTopPadding()), navHostController)

                }
            }
        }
    }
}
