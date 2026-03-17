package com.onemoreburh.mineswap.ui.game.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.FIELD_COLUMN_MODIFIER
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.FIELD_ROW_MODIFIER


@Composable
fun Field(){

    Column(
        modifier = FIELD_COLUMN_MODIFIER
    ) {
        for (i in 0..8) {
            Row(
                modifier = FIELD_ROW_MODIFIER,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (j in 0..8) {
                    FieldSquare(j, i)
                }
            }
        }
    }

}