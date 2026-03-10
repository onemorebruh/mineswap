package com.onemoreburh.mineswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.onemoreburh.mineswap.ui.bottomBar.BottomBar
import com.onemoreburh.mineswap.ui.game.Game
import com.onemoreburh.mineswap.ui.theme.MineswapTheme
import com.onemoreburh.mineswap.ui.topBar.TopBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MineswapTheme {

                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    topBar = {
                        TopBar()
                    },
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