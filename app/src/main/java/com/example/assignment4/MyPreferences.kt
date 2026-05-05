package com.example.assignment4

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MyPreferences(private val context: Context) {

    private object PreferenceKeys {
        val showRating: Preferences.Key<Boolean> = booleanPreferencesKey("show_rating")
    }

    fun getShowRating(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.showRating] ?: false
    }

    suspend fun setShowRating(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.showRating] = value
        }
    }
}