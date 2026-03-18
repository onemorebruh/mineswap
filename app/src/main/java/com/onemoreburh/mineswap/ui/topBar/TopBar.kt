package com.onemoreburh.mineswap.ui.topBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp
import com.onemoreburh.mineswap.logic.FlagController.flagsAmount
import com.onemoreburh.mineswap.logic.MAX_FLAGS
import com.onemoreburh.mineswap.ui.theme.TEXT_COLOR
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.TOP_BAR_ROW_MODIFIER

@Composable
fun TopBar(
){
    val textFlags = flagsAmount.observeAsState(MAX_FLAGS);

    Row(
        modifier = TOP_BAR_ROW_MODIFIER,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("Flags: ${textFlags.value}",
            color = TEXT_COLOR,
            fontSize = 50.sp)
    }
}