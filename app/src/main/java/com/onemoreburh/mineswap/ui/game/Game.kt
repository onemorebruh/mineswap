package com.onemoreburh.mineswap.ui.game

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.onemoreburh.mineswap.ui.game.field.Field
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.GAME_MODIFIER


@Composable
fun Game() {
    Box(modifier = GAME_MODIFIER,
    ){
        Field()
    }
}