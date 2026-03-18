package com.onemoreburh.mineswap.ui.game.field

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onemoreburh.mineswap.R
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_IS_ENABLED
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_IS_FLAG_FREE
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_TEXT
import com.onemoreburh.mineswap.logic.GameController.ifWin
import com.onemoreburh.mineswap.logic.field.FieldController.allSquares
import com.onemoreburh.mineswap.ui.font.Jersey10
import com.onemoreburh.mineswap.ui.theme.BORDER_COLOR
import com.onemoreburh.mineswap.ui.theme.PRIMARY_COLOR
import com.onemoreburh.mineswap.ui.theme.SECONDARY_COLOR
import com.onemoreburh.mineswap.ui.theme.TEXT_COLOR
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.FIELD_SQUARE_MODIFIER
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.FIELD_SQUARE_SHAPE
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FieldSquare(x: Int, y: Int) {

    //Don't touch it
    allSquares[y][x].setCoordinates(x,y)

    val isEnabled = allSquares[y][x].isEnabled.observeAsState(DEFAULT_SQUARE_IS_ENABLED);
    val isFlagFree = allSquares[y][x].isFlagFree.observeAsState(DEFAULT_SQUARE_IS_FLAG_FREE);
    val squareText = allSquares[y][x].squareText.observeAsState(DEFAULT_SQUARE_TEXT);

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

                    }
                }
            }
            ifWin();//every turn checks if user win
        }
    }


    Button(
        onClick = {
            /* check LaunchedEffect for it */},
        enabled = isEnabled.value,
        modifier = FIELD_SQUARE_MODIFIER,
        contentPadding = PaddingValues(0.dp),
        shape = FIELD_SQUARE_SHAPE,
        colors = ButtonDefaults.buttonColors(
            containerColor = PRIMARY_COLOR,
            disabledContainerColor = SECONDARY_COLOR

        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (isEnabled.value) BORDER_COLOR else SECONDARY_COLOR,
        ),
        interactionSource = interactionSource//for long click implementation
    ){

        //bombs around
        AnimatedVisibility(isFlagFree.value,
            Modifier) {
            Text(squareText.value,
                Modifier
                    .padding(0.dp),
                //textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = TEXT_COLOR,
                fontFamily = Jersey10
                )

        }

        //flag
        AnimatedVisibility(!isFlagFree.value, Modifier) {
            Icon(
                painter = painterResource(id = R.drawable.flag_24),
                contentDescription = "flag marked square",
                modifier = Modifier.padding(0.dp),
            )
        }
    }
}

