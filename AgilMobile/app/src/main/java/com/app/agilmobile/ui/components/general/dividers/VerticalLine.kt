package com.app.agilmobile.ui.components.general.dividers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.agilmobile.ui.theme.Black30

@Composable
fun VerticalLine() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(3.dp)
            .background(Black30)
            .padding(6.dp)
    )
}
