package com.onemoreburh.mineswap.ui.theme.individualThemeProperties

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.ui.theme.SECONDARY_COLOR


val GAME_TOP_GAP = 60.dp;

val GAME_MODIFIER = Modifier
    .fillMaxWidth()
    .padding(top = GAME_TOP_GAP)
    .background(SECONDARY_COLOR)