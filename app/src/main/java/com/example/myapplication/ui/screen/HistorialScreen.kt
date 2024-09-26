package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.LexendFontFamily
import com.example.myapplication.ui.theme.LightBlue
import com.example.myapplication.ui.theme.DarkBlue

@Composable
fun HistorialScreen(navController: NavController){
    Column {
        HistorialTile()
        SubTitle("Próximas alarmas")
        MedicationCard(navController,"12:00 AM")
        SubTitle(subTitleName = "Resumen medicamentos")
        MedicationResumeCard("Curcetin - 9:00 AM")
    }
}

@Composable
fun HistorialTile(){
    val imageModifier = Modifier
        .size(80.dp)
        .padding(22.dp)
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(LightBlue)
            .fillMaxWidth(),
    ) {
        Image(painter = painterResource(R.drawable.logomedicheck),
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
        Text(text = "Historial",
            fontFamily = LexendFontFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium
        )
        Image(painter = painterResource(R.drawable.person),
            contentDescription = "Person",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
    }
}

@Composable
fun SubTitle(subTitleName: String){
    val textModifier = Modifier
        .background(DarkBlue, shape = RoundedCornerShape(50))
        .fillMaxWidth()
        .padding(12.dp)

    Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 25.dp)){
        Text(text = "${subTitleName}",
            fontFamily = LexendFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            textDecoration = TextDecoration.Underline,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = textModifier)
    }
}

@Composable
fun MedicationCard(navController: NavController, hora: String){
    val borderModifier = Modifier
        .border(2.dp, Color.Black)
        .fillMaxWidth()

    Box(modifier = Modifier.padding(horizontal = 25.dp)) {
        Column(modifier = borderModifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightBlue)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Curcetin",
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 24.sp
                )
                Text(
                    text = "1 Cápsula",
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 24.sp
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${hora}",
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 32.sp
                )

                IconButton(
                    onClick = {
                        navController.navigate("detail_photo")
                    },
                    modifier = Modifier
                        .size(50.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.curccetin),
                        contentDescription = "IconButton",
                        modifier = Modifier
                            .size(38.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MedicationResumeCard(description: String){

    Box(modifier = Modifier.padding(horizontal = 25.dp)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightBlue)
                .padding(vertical = 17.dp),
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
