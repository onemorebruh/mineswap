package com.onemoreburh.mineswap.game.field

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.game.field.Constants.SquareSize
import com.onemoreburh.mineswap.ui.theme.Pink80
import com.onemoreburh.mineswap.ui.theme.Purple80
import com.onemoreburh.mineswap.ui.theme.PurpleGrey80

@Composable
fun FieldSquare() {
    //button states
    var enabled by remember{ mutableStateOf(true) }

    Button(
        onClick = {
            //disable button
            enabled = false
        },
        enabled = enabled,
        modifier = Modifier.size(SquareSize),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            disabledContainerColor = PurpleGrey80

        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (enabled) Pink80 else PurpleGrey80,
        ),
    ) {
        if (enabled) " " else GetMinesAround()
    }
}


@Composable
fun GetMinesAround(){
    //TODO center text
    Text("0")
}