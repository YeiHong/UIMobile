package com.example.myapplication.data

import android.media.Image
import java.util.Date

data class Alarm(
    val name: String,
    val description: String,
    val time: Date,
    val image: Image
)

