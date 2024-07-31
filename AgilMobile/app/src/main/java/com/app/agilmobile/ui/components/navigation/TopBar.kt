package com.app.agilmobile.ui.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.agilmobile.ui.theme.Blue
import com.app.agilmobile.ui.theme.Orange

@Composable
fun TopBar(onMenuClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp)
    ) {
        IconButton(
            onClick = onMenuClick, modifier = Modifier.background(Blue, RoundedCornerShape(14.dp))
        ) {
            Icon(
                imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White
            )
        }

        IconButton(
            onClick = { }, modifier = Modifier.background(Orange, RoundedCornerShape(14.dp))
        ) {
            Icon(
                imageVector = Icons.Default.ChatBubble,
                contentDescription = "Chat",
                tint = Color.White
            )
        }
    }
}
