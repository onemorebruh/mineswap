package com.onemoreburh.mineswap.ui.game.field

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.onemoreburh.mineswap.logic.FieldController.getNumberBombsByCoordinates
import com.onemoreburh.mineswap.ui.game.field.Constants.SquareSize
import com.onemoreburh.mineswap.ui.theme.Pink80
import com.onemoreburh.mineswap.ui.theme.Purple80
import com.onemoreburh.mineswap.ui.theme.PurpleGrey80
import com.onemoreburh.mineswap.ui.theme.Red80

@Composable
fun FieldSquare(x: Int, y: Int) {
    //button states
    var enabled by remember{ mutableStateOf(true) }
    var squareText by remember { mutableStateOf( "") }

    Button(
        onClick = {
            //disable button
            enabled = false
            squareText = getNumberBombsByCoordinates(x,y).toString()
        },
        enabled = enabled,
        modifier = Modifier.size(SquareSize),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            disabledContainerColor = PurpleGrey80

        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (enabled) Pink80 else PurpleGrey80,
        ),
    ){
        Text(squareText,
            Modifier
                .padding(0.dp),
            //textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Red80
        )
    }
}

