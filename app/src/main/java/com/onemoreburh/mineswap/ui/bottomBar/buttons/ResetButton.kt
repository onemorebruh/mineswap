package com.onemoreburh.mineswap.ui.bottomBar.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.onemoreburh.mineswap.R
import com.onemoreburh.mineswap.logic.bottomBar.ResetController
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.RESET_BUTTON_COLORS
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.RESET_BUTTON_MODIFIER

@Composable
fun ResetButton(){
    Button(
        modifier = RESET_BUTTON_MODIFIER,
        onClick = {
            ResetController.resetGame();
        },
        colors = RESET_BUTTON_COLORS
    ) {
        Icon(
            painter = painterResource(id = R.drawable.reset_game_24),
            contentDescription = "reset game",
            modifier = RESET_BUTTON_MODIFIER,
        )
    }
}