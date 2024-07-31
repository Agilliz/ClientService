package com.app.agilmobile.ui.components.general.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.app.agilmobile.ui.theme.Grey

@Composable
fun DeliveryTextField(
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
){
    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(Grey),
        label = { Text(
            text = label,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
        ) },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon, contentDescription = "Icon"
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}
