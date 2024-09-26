package com.example.myapplication.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  "home"){
        composable("home"){
            HistorialScreen(navController = navController)
        }
        composable("detail_photo"){
            PhotoDetailScreen(navController = navController)
        }
        composable("alarm") { 
            AlarmScreen(navController = navController)
        }
        composable("alarm_ring") {
            AlarmRingScreen(navController = navController)
        }
        composable("alarm_check") {
            AlarmCheck(navController = navController)
        }
        composable("home_pos") {
            PosHistorialScrenn(navController = navController)
        }
        composable("resumen") {
            MedicationSummaryScreen(navController = navController)
        }
    }
}