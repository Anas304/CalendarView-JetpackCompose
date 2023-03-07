package com.example.mcalendar.ui.component

import android.widget.CalendarView
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendar() {

    var date by remember{ mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                AndroidView(factory = {CalendarView(it)}, update = {
                    it.setOnDateChangeListener{ _, year, month, day ->
                        date = "$day-${month + 1}-$year"
                        Toast.makeText(context, "selected Date is $date", Toast.LENGTH_SHORT).show()
                    }
                })
            }

        }
    )
}