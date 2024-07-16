package com.app.agilmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.app.agilmobile.ui.theme.Black30

@Composable
fun TextFieldStandard(
    text: String,
    onTextChange: (String) -> Unit,
    shape: Shape = RoundedCornerShape(16.dp),
    label: String,
    leadingIcon: ImageVector,
    isPassword: Boolean = false
) {
    val visualTransformation = if (isPassword) PasswordVisualTransformation()
                                        else VisualTransformation.None


    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape)
            .border(1.dp, Black30, shape),
        label = { Text(label) },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "Icon"
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        visualTransformation = visualTransformation
    )
}
