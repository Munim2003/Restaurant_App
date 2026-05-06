package com.example.assignment4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddRestaurantScreen(modifier: Modifier) {

    var nameText by rememberSaveable{ mutableStateOf("") }
    var locationText by rememberSaveable{ mutableStateOf("") }
    var ratingText by rememberSaveable{ mutableStateOf("") }
    val viewModel = viewModel{ AddRestaurantVM(MyApp.repository) }

    Surface(modifier = modifier.fillMaxSize().padding(16.dp), shape = RoundedCornerShape(10.dp), shadowElevation = 30.dp) {
        Column(Modifier.fillMaxSize().padding(6.dp)) {
            TextField(
                value = nameText,
                onValueChange = {nameText=it},
                label = {Text("Name")},
            )
            TextField(
                value = locationText,
                onValueChange = {locationText=it},
                label = {Text("Location")},
            )
            TextField(
                value = ratingText,
                onValueChange = {ratingText=it},
                label = {Text("Rating")},
            )
            Button(onClick = {viewModel.addRestaurant(nameText, locationText, ratingText.toDouble())}) {Text("Add") }
        }
    }
}