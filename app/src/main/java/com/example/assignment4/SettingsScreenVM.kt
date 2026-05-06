package com.example.assignment4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsScreenVM(private val repository: RestaurantRepository) : ViewModel(){
    val showRating: StateFlow<Boolean> = repository.getShowRating()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun toggleRating(value: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.setShowRating(value)
        }
    }
}