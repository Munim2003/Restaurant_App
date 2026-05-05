package com.example.assignment4

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RestaurantRepository(private val restaurantDao: RestaurantDAO, private val myPreferences: MyPreferences) {


    suspend fun getAll() : Flow<List<Restaurant>>{
        return restaurantDao.getAll()
    }
    suspend fun insert(restaurant: Restaurant){
        return restaurantDao.insert(restaurant)
    }

    suspend fun setShowRating(value: Boolean) {
        myPreferences.setShowRating(value)
    }
    fun getShowRating(): Flow<Boolean> {
        return myPreferences.getShowRating()
    }


    }
