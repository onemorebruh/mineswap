package com.onemoreburh.mineswap.dialogs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.onemoreburh.mineswap.logic.bottomBar.ResetController
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.DIALOG_CARD_MODIFIER
import com.onemoreburh.mineswap.ui.theme.individualThemeProperties.DIALOG_TEXT_MODIFIER
import kotlinx.coroutines.delay

@Composable
fun Win(){
    Dialog(onDismissRequest = {}) {
        Card(
            modifier = DIALOG_CARD_MODIFIER,
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "YOU WIN!!! CONGRATS!!!",
                modifier = DIALOG_TEXT_MODIFIER,
                textAlign = TextAlign.Center,
            )

            LaunchedEffect(Unit) {
                delay(timeMillis = 5000)//delay 5 seconds
                ResetController.resetGame();
            }
        }
    }
}