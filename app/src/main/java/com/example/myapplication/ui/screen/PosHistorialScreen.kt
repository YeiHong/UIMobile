package com.example.myapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.myapplication.ui.theme.DarkBlue
import com.example.myapplication.ui.theme.LexendFontFamily
import com.example.myapplication.ui.theme.LightBlue

@Composable
fun PosHistorialScrenn(navController: NavController){
    Column {
        HistorialTile()
        SubTitle("Próximas alarmas")
        MedicationCard(navController, "3:00 PM")
        SubTitle("Resumen medicamentos")
        MedicationResumeCardNav(navController,"Curcetin - 12:00 AM")
    }
}

@Composable
fun MedicationResumeCardNav(navController: NavController, description: String){

    Box(modifier = Modifier.padding(horizontal = 25.dp)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightBlue)
                .padding(vertical = 17.dp)
                .clickable { navController.navigate("resumen") },
            verticalAlignment = Alignment.CenterVertically,
        ){

            Spacer(modifier = Modifier.width(25.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(DarkBlue, shape = CircleShape),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_check_24),
                    contentDescription = "Check",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(25.dp))

            Text(
                text = "${description}",
                fontFamily = LexendFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            )
        }
    }
}