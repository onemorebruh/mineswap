package com.onemoreburh.mineswap.ui.theme.individualThemeProperties

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.ui.theme.OPTIONAL_COLOR
import com.onemoreburh.mineswap.ui.theme.SECONDARY_COLOR
import com.onemoreburh.mineswap.ui.theme.TEXT_COLOR

val BORDER_WIDTH = 2.dp
val RESET_BUTTON_SHAPE = RoundedCornerShape(50.dp)

val RESET_BUTTON_MODIFIER = Modifier
    .height(100.dp)
    .width(150.dp)
    .border(BORDER_WIDTH,
        SECONDARY_COLOR,
        RESET_BUTTON_SHAPE);

val RESET_BUTTON_ICON_MODIFIER = Modifier
    .height(75.dp)
    .width(125.dp);

val RESET_BUTTON_COLORS  = ButtonColors(
    containerColor = OPTIONAL_COLOR,
    contentColor = TEXT_COLOR,

    // NOTE have to never be used
    disabledContentColor = SECONDARY_COLOR,
    disabledContainerColor = SECONDARY_COLOR
)