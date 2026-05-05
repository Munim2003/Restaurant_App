package com.example.assignment4

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RestaurantListScreen(modifier: Modifier = Modifier){
    val viewModel = viewModel{ RestaurantListVM(MyApp.repository) }

    Surface(modifier = modifier.fillMaxSize().padding(16.dp), shape = RoundedCornerShape(10.dp), shadowElevation = 30.dp) {
        LazyColumn(Modifier.fillMaxSize().padding(6.dp)) {
            item{Text("Restaurants", fontSize = 32.sp,fontWeight = FontWeight.Bold, color = Color(0xFF5C6BC0) )}
            item{Spacer(modifier = Modifier.height(13.dp))}
            items(viewModel.restaurants.value.size){restaurant->
                Surface(modifier = Modifier.fillMaxWidth().clickable{
                    val navHostController = null
                    navHostController.navigate("WorkerDetailScreen/${worker.name}")
                }, shape = RoundedCornerShape(10.dp), color = Color(0xFFEEEEEE)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(worker.name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5C6BC0))
                        Text("Hours Worked: ${worker.hoursWorked}", color =  Color.Magenta, fontSize = 18.sp)
                        Text("Rate: $${"%.2f".format(worker.rate)}", color =  Color.Magenta, fontSize = 18.sp)
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}