package com.onemoreburh.mineswap.bottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.bottomBar.buttons.ResetButton
import com.onemoreburh.mineswap.bottomBar.buttons.SettingsButton
import com.onemoreburh.mineswap.ui.theme.Brown40
import com.onemoreburh.mineswap.ui.theme.Orange40
import com.onemoreburh.mineswap.ui.theme.Red80

@Composable
fun BottomBar(
){
    val navButtonModifier = Modifier
        .height(50.dp)
        .width(70.dp)

    val navButtonColors = ButtonColors(
        containerColor = Brown40,
        contentColor = Orange40,

        // NOTE have to never be used
        disabledContentColor = Red80,
        disabledContainerColor = Red80
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),

        horizontalArrangement = Arrangement.SpaceAround
    ) {

        ResetButton(navButtonColors,navButtonModifier)
        SettingsButton(navButtonColors, navButtonModifier)
    }
}