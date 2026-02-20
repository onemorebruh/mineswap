package com.onemoreburh.mineswap.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.game.field.Constants.GameTopGap
import com.onemoreburh.mineswap.game.field.Field


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