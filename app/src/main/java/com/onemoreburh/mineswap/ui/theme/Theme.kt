package com.onemoreburh.mineswap.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

//NOTE I have chosen to ignore darkColorScheme and alike because of their naming

@Composable
fun MineswapTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        content = content
    )
}
