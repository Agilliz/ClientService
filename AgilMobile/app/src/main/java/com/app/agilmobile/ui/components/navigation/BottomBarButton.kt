package com.app.agilmobile.ui.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.app.agilmobile.ui.theme.Grey

@Composable
fun BottomBarButton(icon: ImageVector, description: String, color: Color) {
    IconButton(
        onClick = { /* Add action logic here */ },
        modifier = Modifier.background(Grey, RoundedCornerShape(14.dp))
    ) {
        Icon(
            imageVector = icon, contentDescription = description, tint = color
        )
    }
}
