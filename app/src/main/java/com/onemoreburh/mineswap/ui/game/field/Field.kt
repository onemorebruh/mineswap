package com.onemoreburh.mineswap.ui.game.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import com.onemoreburh.mineswap.logic.FieldController.fieldFocusRequester
import com.onemoreburh.mineswap.ui.Constants.SquareRowSize


@Composable
fun Field(){
    val fieldContext = LocalContext.current;

    Column(
        modifier = Modifier
            .focusRequester(fieldFocusRequester)
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
                    FieldSquare(j, i)
                }
            }
        }
    }

}