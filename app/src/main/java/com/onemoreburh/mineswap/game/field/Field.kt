package com.onemoreburh.mineswap.game.field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.game.field.Constants.SquareRowSize
import com.onemoreburh.mineswap.ui.theme.Pink40


@Composable
fun Field(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (i in 0..8) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.width(IntrinsicSize.Min)// fill the width without gaps
                    .height(SquareRowSize),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (j in 0..8) {
                    FieldSquare()
                }
            }
        }
    }

}