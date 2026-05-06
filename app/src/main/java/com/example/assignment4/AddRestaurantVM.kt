package com.example.assignment4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4.MyApp.Companion.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddRestaurantVM(repository : RestaurantRepository) : ViewModel() {
    fun addRestaurant(name: String, location: String, rating: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(Restaurant(name = name, location = location, rating = rating))
        }
    }
}