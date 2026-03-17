package com.onemoreburh.mineswap.ui.theme.individualThemeProperties

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onemoreburh.mineswap.ui.theme.OPTIONAL_COLOR
import com.onemoreburh.mineswap.ui.theme.SECONDARY_COLOR
import com.onemoreburh.mineswap.ui.theme.TEXT_COLOR

val RESET_BUTTON_MODIFIER = Modifier
    .height(50.dp)
    .width(70.dp);

val RESET_BUTTON_COLORS  = ButtonColors(
    containerColor = OPTIONAL_COLOR,
    contentColor = TEXT_COLOR,

    // NOTE have to never be used
    disabledContentColor = SECONDARY_COLOR,
    disabledContainerColor = SECONDARY_COLOR
)