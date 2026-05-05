package com.example.assignment4

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class MyApp : Application() {
    companion object{
        lateinit var repository: RestaurantRepository
    }

    override fun onCreate() {
        super.onCreate()
        val db = runBlocking(Dispatchers.IO){
            Room.databaseBuilder(
                this@MyApp.applicationContext,
                RestaurantDatabase::class.java, "restaurant"
            ).build()


        }
        val myPreferences = MyPreferences(this)
        repository = RestaurantRepository(db.restaurantDao()!!, myPreferences)

        runBlocking(Dispatchers.IO){
            repository.insert(Restaurant(name = "The Melting Pot", location = "Farmingdale", rating = 4.0))
            repository.insert(Restaurant(name = "Burger King", location = "Farmingdale", rating = 2.0))
            repository.insert(Restaurant(name = "The Lakehouse", location = "Bay Shore", rating = 4.5))
            repository.insert(Restaurant(name = "Miller's Ale House", location = "Levitown", rating = 3.5))
            repository.insert(Restaurant(name = "Secret Thai Kitchen", location = "Freeport", rating = 4.0))
            repository.insert(Restaurant(name = "Cafe Continental", location = "Manhasset", rating = 4.0))
            repository.insert(Restaurant(name = "Friendly's", location = "Stony Brook", rating = 2.5))

        }
    }
}