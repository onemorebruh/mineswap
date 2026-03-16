package com.onemoreburh.mineswap.ui.topBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.logic.FlagController.flagsAmount
import com.onemoreburh.mineswap.logic.MAX_FLAGS
import com.onemoreburh.mineswap.ui.theme.Brown40
import com.onemoreburh.mineswap.ui.theme.Orange40
import com.onemoreburh.mineswap.ui.theme.Red80

@Composable
fun TopBar(
){
    val textFlags = flagsAmount.observeAsState(MAX_FLAGS);
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
            .padding(top = 25.dp),

        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("Flags: ${textFlags.value}")
    }
}