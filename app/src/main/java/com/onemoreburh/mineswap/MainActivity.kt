package com.onemoreburh.mineswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.onemoreburh.mineswap.dialogs.Lose
import com.onemoreburh.mineswap.dialogs.Win
import com.onemoreburh.mineswap.logic.GameController
import com.onemoreburh.mineswap.ui.bottomBar.BottomBar
import com.onemoreburh.mineswap.ui.game.Game
import com.onemoreburh.mineswap.ui.theme.MineswapTheme
import com.onemoreburh.mineswap.ui.theme.SECONDARY_COLOR
import com.onemoreburh.mineswap.ui.topBar.TopBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MineswapTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    contentColor = SECONDARY_COLOR,
                    topBar = {
                        TopBar()
                    },
                    bottomBar = {
                        BottomBar()
                    }
                ) { innerPadding ->
                    val isGameWon = GameController.isGameWon.observeAsState(null);


                    Game(
                    )
                    if (isGameWon.value == true){
                        Win()
                    }
                    if (isGameWon.value == false){
                        Lose();
                    }
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