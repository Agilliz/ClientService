package com.app.agilmobile.ui.components.general.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonStandard(
    text: String,
    onClick: () -> Unit,
    buttonColor: Color,
    textColor: Color,
    cornerRadius: Int,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(cornerRadius.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp, pressedElevation = 6.dp
        )
    ) {
        Text(
            text = text, color = textColor, fontSize = 24.sp, fontWeight = FontWeight.SemiBold
        )
    }
}

