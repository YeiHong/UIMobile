package com.example.myapplication.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.DarkBlue
import com.example.myapplication.ui.theme.LexendFontFamily
import com.example.myapplication.ui.theme.LightBlue

@Composable
fun MedicationSummaryScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleBack(navController)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .align(alignment = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(163,194,227))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = "CURCETIN",
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Cantidad total:",
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                CircularProgressBar(progress = 2f / 5f, modifier = Modifier.align(Alignment.CenterHorizontally))

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Seguimiento:",
                    fontFamily = LexendFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                FollowUpItem("09:00 AM", "10s después", true)
                FollowUpItem("12:00 AM", "5s después", true)
                FollowUpItem("03:00 PM", "esperando", false)
                FollowUpItem("06:00 PM", "esperando", false)
                FollowUpItem("09:00 PM", "esperando", false)
            }
        }
    }
}

@Composable
fun TitleBack(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightBlue)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "Back",
            modifier = Modifier
                .size(45.dp)
                .clickable { navController.navigate("home_pos") }
        )

        Text(
            text = "Resumen",
            fontFamily = LexendFontFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 50.dp)
        )
    }
}

@Composable
fun FollowUpItem(time: String, status: String, isCompleted: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .background(DarkBlue, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = if (isCompleted) painterResource(id = R.drawable.baseline_check_24)
                else painterResource(id = R.drawable.baseline_alarm_24),
                contentDescription = if (isCompleted) "Completed" else "Pending",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "$time - $status",
            fontFamily = LexendFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp)
    }
}

@Composable
fun CircularProgressBar(progress: Float, modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(100.dp)) {
            drawArc(
                color = Color.Gray,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(10.dp.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = Color.Black,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(10.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = "2/5",
            fontFamily = LexendFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 32.sp)
    }
}