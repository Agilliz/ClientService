package com.app.agilmobile.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.app.agilmobile.ui.theme.Orange

@Composable
fun ButtonOrange(
    text: String,
    onClick: () -> Unit,
    buttonColor: Color,
    textColor: Color ,
    buttonWidth: Int,
    buttonHeight: Int,
    cornerRadius: Int,
    defaultElevation: Int,
    pressedElevation: Int
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = Modifier
            .width(buttonWidth.dp)
            .height(buttonHeight.dp),
        shape = RoundedCornerShape(cornerRadius.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = defaultElevation.dp,
            pressedElevation = pressedElevation.dp
        )
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

