package com.example.assignment4

import android.media.Rating
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant(
    @PrimaryKey val name: String,
    val location: String,
    val rating: Double
)