package com.example.myapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.LexendFontFamily

@Composable
fun AlarmScreen(navController: NavController){
    Column {
        NotificationAlarm(navController = navController)
        SubTitle("Próximas alarmas")
        MedicationCard(navController, "12:00 AM")
        SubTitle(subTitleName = "Resumen medicamentos")
        MedicationResumeCard("Curcetin - 9:00 AM")
    }
}

@Composable
fun NotificationAlarm(navController: NavController){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.Black, shape = RoundedCornerShape(bottomEndPercent = 30, bottomStartPercent = 30))
            .fillMaxWidth()
            .clickable { navController.navigate("alarm_ring") },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_alarm_24),
            contentDescription = "Alarma icon",
            tint = Color.White,
            modifier = Modifier
                .padding(vertical = 22.dp)
                .size(60.dp)
        )

        Text(
            text = "Curcetin",
            fontFamily = LexendFontFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 50.dp)
        )

    }
}