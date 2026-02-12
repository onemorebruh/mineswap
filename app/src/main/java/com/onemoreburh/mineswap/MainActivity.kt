package com.onemoreburh.mineswap

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.ui.theme.MineswapTheme
import com.onemoreburh.mineswap.ui.theme.Pink80
import com.onemoreburh.mineswap.ui.theme.Purple80
import com.onemoreburh.mineswap.ui.theme.PurpleGrey80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MineswapTheme {

                Scaffold(modifier = Modifier
                    .fillMaxSize()
                ) { innerPadding ->
                    Screen(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Square() {
    //button states
    var enabled by remember{ mutableStateOf(true) }
    //button styles


    Button(
        onClick = {
            //disable button
            enabled = false
        },
        enabled = enabled,
        modifier = Modifier
            .padding(50.dp)
            .size(50.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            disabledContainerColor = PurpleGrey80

        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (enabled) Pink80 else PurpleGrey80,
        ),
    ) {
        if (enabled) " " else GetMinesAround()
    }
}

@Composable
fun GetMinesAround(){
    //TODO center text
    Text("0")
}

@Composable
fun Field(){
    Square()
}


@Composable
fun Screen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.secondary)
    ){
        Field()

    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MineswapTheme {
        Screen()
    }
}