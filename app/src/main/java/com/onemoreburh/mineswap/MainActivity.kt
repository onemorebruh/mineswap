package com.onemoreburh.mineswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.onemoreburh.mineswap.bottomBar.BottomBar
import com.onemoreburh.mineswap.game.Game
import com.onemoreburh.mineswap.game.field.Field
import com.onemoreburh.mineswap.ui.theme.MineswapTheme


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
                    Game(
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GamePreview() {
    MineswapTheme {
        Game()
    }
}