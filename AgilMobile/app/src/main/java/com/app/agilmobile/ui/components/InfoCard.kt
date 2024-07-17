package com.app.agilmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.theme.AgilMobileTheme

@Composable
fun InfoCard(
    icon1: ImageVector,
    info1: String,
    icon2: ImageVector,
    info2: String,
    icon3: ImageVector,
    info3: String,
    onCardClick: () -> Unit,
) {

    var isPressed by remember { mutableStateOf(false) }

    val elevation = if (isPressed) 8.dp else 4.dp
    Card(
        elevation = CardDefaults.cardElevation(elevation),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        onClick = {
            isPressed = true
            onCardClick()
            isPressed = false
        },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon1,
                        contentDescription = "icon1"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = info1,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = icon2, contentDescription = "icon2")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = info2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = icon3, contentDescription = "icon3")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = info3,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "BoxSelection",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview() {
    AgilMobileTheme {
        InfoCard(
            icon1 = Icons.Default.Info,
            info1 = "Zona Leste 1",
            icon2 = Icons.Default.Info,
            info2 = "Ceps: 080 - 081 - 082 - 083",
            icon3 = Icons.Default.Info,
            info3 = "Pacotes: 35",
            onCardClick = {},
        )
    }
}
