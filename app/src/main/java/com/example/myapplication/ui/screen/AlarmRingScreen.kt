package com.example.myapplication.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.LexendFontFamily
import com.example.myapplication.ui.theme.LightBlue

@Composable
fun AlarmRingScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        TitleTime()
        MedicationCard()
        ButtonsAlarm(navController)
    }
}

@Composable
fun TitleTime(){
    Column (horizontalAlignment = Alignment.CenterHorizontally,){
        Text(
            text = "AM",
            fontFamily = LexendFontFamily,
            fontSize = 64.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(start = 200.dp)
        )
        Text(
            text = "12:00",
            fontFamily = LexendFontFamily,
            fontSize = 96.sp,
            fontWeight = FontWeight.Black,
        )

    }
}
@Preview
@Composable
fun MedicationCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .background(LightBlue)
            .border(2.dp, color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(LightBlue),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.curccetin),
                contentDescription = "Imagen del medicamento",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .border(1.dp, color = Color.Black)
                    .padding()
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Curcetin",
                    textDecoration = TextDecoration.Underline,
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 32.sp
                )
                Text(
                    text = "1 Cápsula",
                    textDecoration = TextDecoration.Underline,
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun ButtonsAlarm(navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate("alarm_check")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0,59,92)),
            modifier = Modifier
                .width(212.dp)
                .padding(bottom = 10.dp)
        ) {
            Text(
                text = "Detener",
                fontFamily = LexendFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Button(
            onClick = {
                navController.navigate("alarm_check")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(163,194,227)),
            modifier = Modifier
                .width(154.dp)
                .padding(bottom = 50.dp)
        ) {
            Text(
                text = "Posponer",
                fontFamily = LexendFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}