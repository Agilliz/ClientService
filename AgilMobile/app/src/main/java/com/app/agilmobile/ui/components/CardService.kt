package com.app.agilmobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.theme.Orange

@Composable
fun CardService(
    title: String,
    imageResId: Int,
    icon: ImageVector,
    onCardClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val elevation = if (isPressed) 8f.dp else 4f.dp

    Card(
        elevation = CardDefaults.cardElevation(elevation),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable(
                onClick = {
                    isPressed = true
                    onCardClick()
                    isPressed = false
                },
                onClickLabel = null,
                role = null
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(8.dp)
                .height(IntrinsicSize.Min)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(IntrinsicSize.Min)
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Image",
                    modifier = Modifier.size(100.dp)
                )
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Orange)
                        .padding(4.dp),
                    tint = Color.White
                )
            }
        }
    }
}