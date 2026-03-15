package com.onemoreburh.mineswap.ui.game.field

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onemoreburh.mineswap.R
import com.onemoreburh.mineswap.logic.field.FieldController.allSquares
import com.onemoreburh.mineswap.logic.field.FieldController
import com.onemoreburh.mineswap.ui.SquareSize
import com.onemoreburh.mineswap.ui.theme.Pink80
import com.onemoreburh.mineswap.ui.theme.Purple80
import com.onemoreburh.mineswap.ui.theme.PurpleGrey80
import com.onemoreburh.mineswap.ui.theme.Red80
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FieldSquare(x: Int, y: Int) {

    //Don't touch it
    FieldController.allSquares[y][x].setCoordinates(x,y)

    var isEnabled by remember { mutableStateOf(allSquares[y][x].isEnabled) }
    var isFlagFree by remember { mutableStateOf(allSquares[y][x].isFlagFree) }
    var squareText by remember { mutableStateOf(allSquares[y][x].squareText) }

    val interactionSource = remember { MutableInteractionSource() };
    val viewConfiguration = LocalViewConfiguration.current;

    LaunchedEffect(interactionSource) {
        var isLongClick = false;

        interactionSource.interactions.collectLatest { interaction ->
            when (interaction){
                is PressInteraction.Press -> {
                    isLongClick = false
                    delay(viewConfiguration.longPressTimeoutMillis)
                    isLongClick = true


                    //long click commands
                    allSquares[y][x].flagSquare()

                }

                is PressInteraction.Release -> {
                    if (isLongClick.not()){

                        //short click commands
                        allSquares[y][x].openSquare()
                        //otherwise act like disabled

                    }
                }
            }
        }
    }


    Button(
        onClick = {
            /* check LaunchedEffect for it */},
        enabled = isEnabled,
        modifier = Modifier.size(SquareSize),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            disabledContainerColor = PurpleGrey80

        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (isEnabled) Pink80 else PurpleGrey80,
        ),
        interactionSource = interactionSource//for long click implementation
    ){

        //bombs around
        AnimatedVisibility(isFlagFree,
            Modifier) {
            Text(squareText,
                Modifier
                    .padding(0.dp),
                //textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Red80,

                )

        }

        //flag
        AnimatedVisibility(!isFlagFree, Modifier) {
            Icon(
                painter = painterResource(id = R.drawable.flag_24),
                contentDescription = "flag marked square",
                modifier = Modifier.padding(0.dp),
            )
        }
    }
}

