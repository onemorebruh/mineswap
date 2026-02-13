package com.onemoreburh.mineswap.bottomBar

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.onemoreburh.mineswap.R

@Composable
fun SettingsButton(buttonColors: ButtonColors, buttonModifier: Modifier){

    Button(
        onClick = {},
        colors = buttonColors
    ) {
        Icon(
            painter = painterResource(id = R.drawable.settings_24),
            contentDescription = "game settings",
            modifier = buttonModifier,
        )
    }
}