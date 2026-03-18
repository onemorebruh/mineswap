package com.onemoreburh.mineswap.ui.bottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.onemoreburh.mineswap.ui.bottomBar.buttons.ResetButton
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.BOTTOM_BAR_ROW_MODIFIER

@Composable
fun BottomBar(
){
        Row(
                modifier = BOTTOM_BAR_ROW_MODIFIER,
                horizontalArrangement = Arrangement.SpaceAround
        ) {
                ResetButton()
        }
}