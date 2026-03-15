package com.onemoreburh.mineswap.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.onemoreburh.mineswap.ui.Constants.GameTopGap
import com.onemoreburh.mineswap.ui.game.field.Field


@Composable
fun Game() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = GameTopGap)
        .background(MaterialTheme.colorScheme.secondary),
    ){
        Field()
    }
}