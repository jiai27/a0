package com.example.decisionmakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionmakingapp.ui.theme.DecisionMakingAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionMakingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier){
    var numClicks by remember { mutableIntStateOf(value = 0) }
    var statusMsg by remember {mutableStateOf(value = "Should we go?")}

    Column(modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = statusMsg,
                fontSize = 32.sp,
                color = Color.Black
            )
        }
        Row(modifier){
            Button(
                onClick = {
                    numClicks +=1
                    statusMsg = yesOrNo(buttonClicked = "Ok")
                },
                modifier.padding(end = 16.dp)
            ){
                Text("Ok!")
            }
            Button(
                onClick = {
                    numClicks +=1
                    statusMsg = yesOrNo(buttonClicked = "Meh")
                },
                modifier.padding(end = 16.dp)
            ){
                Text("Meh")
            }
            Button(
                onClick = {
                    numClicks +=1
                    statusMsg = yesOrNo(buttonClicked = "Nah")
                }
            ){
                Text("Nah")
            }

        }

        Row(modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Clicks: $numClicks")
        }

        Row(modifier.fillMaxWidth().padding(all=16.dp), horizontalArrangement = Arrangement.Center){
            Text(
                text = "Student Info:" + "\n" + "StudentID: 1806523" + "\n"+ "CCID: jmcarbon",
                textAlign = TextAlign.Center)
        }

    }

}

fun yesOrNo(buttonClicked: String): String {
    val randomNumber = Random.nextFloat()

    if (buttonClicked == "Ok"){
        println("pressed ok")
        if (randomNumber > 0.25){   //probability: 0.75 yes chance
            return "Yes, I'm going"            //yes
        }
    }
    else if (buttonClicked == "Meh"){
        println("pressed Meh!")
        if (randomNumber > 0.5){    //probability: 0.5 yes
            return "Yes, I'm going"            //yes
        }
    }
    else if (buttonClicked == "Nah"){
        println("pressed Nah")
        if (randomNumber > 0.75){   //probability: 0.25 yes
            return "Yes, I'm going"            //yes
        }
    }
    return "No, not going"
}