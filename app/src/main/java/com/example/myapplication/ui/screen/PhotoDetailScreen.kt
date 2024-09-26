package com.example.myapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.DarkBlue
import com.example.myapplication.ui.theme.LightBlue

@Composable
fun PhotoDetailScreen(navController: NavController){
    Column {
        HistorialTile()
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color.Black),
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .background(LightBlue)
            ) {

                Spacer(modifier = Modifier.height(25.dp))

                Image(
                    painter = painterResource(id = R.drawable.curccetin),
                    contentDescription = "Imagen del producto",
                    modifier = Modifier
                        .size(400.dp)
                        .padding(16.dp),
                    contentScale = ContentScale.Inside
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(DarkBlue, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ){
                        IconButton(onClick = { navController.navigate("alarm") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_check_24),
                                contentDescription = "Check",
                                tint = Color.White,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(DarkBlue, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ){
                        IconButton(onClick = { navController.navigate("alarm") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_change_circle_24),
                                contentDescription = "Change",
                                tint = Color.White,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
}