package com.onemoreburh.mineswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.bottomBar.BottomBar
import com.onemoreburh.mineswap.field.Field
import com.onemoreburh.mineswap.ui.theme.Brown40
import com.onemoreburh.mineswap.ui.theme.MineswapTheme
import com.onemoreburh.mineswap.ui.theme.Orange40
import com.onemoreburh.mineswap.ui.theme.Pink80
import com.onemoreburh.mineswap.ui.theme.Purple80
import com.onemoreburh.mineswap.ui.theme.PurpleGrey40
import com.onemoreburh.mineswap.ui.theme.PurpleGrey80
import com.onemoreburh.mineswap.ui.theme.Red80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MineswapTheme {

                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    bottomBar = {
                        BottomBar()
                    }
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
fun GetMinesAround(){
    //TODO center text
    Text("0")
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