package com.example.learningpart1

import android.R.attr.text
import android.provider.Settings
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview( showBackground = true, showSystemUi = true)
@Composable
fun Stopwatch() {
    var time by remember { mutableStateOf(0L) }
    var start_time by remember { mutableStateOf(0L) }
    var is_running by remember { mutableStateOf( false)}

    LaunchedEffect(is_running)  {
        /*while(is_running){
            delay(10L)
            time+=10L
        }*/
        if(is_running){
            start_time= System.currentTimeMillis()

            while(true){
                time=System.currentTimeMillis() - start_time
                delay(10L)

                if(!is_running) break
            }
        }

    }

    val hour=(time/(1000*60*60))%24
    val min=(time/(1000*60))%60
    val sec=(time/1000)%60
    val milsec= time%1000

    val formatted_time = String.format("%02d:%02d:%02d:%03d",hour,min,sec,milsec)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hour:Minute:Second:Millisecond", fontSize = 20.sp, color =Color(0xFF6650a4))

        Spacer( modifier = Modifier.height(20.dp))

        Text(text = formatted_time, fontSize= 32.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Row(){
            Button(onClick = {is_running = !is_running}){
                Text( text = if(is_running) "stop" else "start")
            }

            Spacer( modifier = Modifier.width(8.dp))

            Button(onClick = {is_running = false
            time=0}){
                Text(text = "Reset")
            }
        }
    }
}