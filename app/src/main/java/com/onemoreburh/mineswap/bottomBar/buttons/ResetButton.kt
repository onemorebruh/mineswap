package com.onemoreburh.mineswap.bottomBar.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.onemoreburh.mineswap.R

@Composable
fun ResetButton(buttonColors: ButtonColors, buttonModifier: Modifier){
    Button(
        onClick = {},
        colors = buttonColors
    ) {
        Icon(
            painter = painterResource(id = R.drawable.reset_game_24),
            contentDescription = "reset game",
            modifier = buttonModifier,
        )
    }
}