package com.onemoreburh.mineswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onemoreburh.mineswap.ui.theme.MineswapTheme
import com.onemoreburh.mineswap.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MineswapTheme {

                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(PurpleGrey80)
                ) { innerPadding ->
                    Screen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Square() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(50.dp)
            .size(30.dp)
            .background(MaterialTheme.colorScheme.primary)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(5.dp)
            ),
        enabled = false,
        shape = ButtonDefaults.shape
    ) {
    }
}

@Composable
fun Field(){
    Square()
}


@Composable
fun Screen(name: String, modifier: Modifier = Modifier) {
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
        Screen("Android")
    }
}