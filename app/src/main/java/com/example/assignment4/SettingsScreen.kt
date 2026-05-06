package com.example.assignment4

import android.widget.Switch
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
fun SettingsScreen(modifier: Modifier){
    val viewModel = viewModel { SettingsScreenVM(MyApp.repository) }
    val isChecked by viewModel.showRating.collectAsState()
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp), shape = RoundedCornerShape(10.dp), shadowElevation = 30.dp) {
        Column(Modifier.fillMaxSize().padding(14.dp)) {
            Text(
                "Settings",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5C6BC0)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Show Rating = $isChecked",
                color = Color.Magenta,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    viewModel.toggleRating(it)
                }
            )
        }
    }
}