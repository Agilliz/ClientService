package com.app.agilmobile.ui.components.service

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Black
import com.app.agilmobile.ui.theme.Orange

data class InfoItem(val icon: ImageVector, val info: String)

@Composable
fun InfoCard(
    infoItems: List<InfoItem>,
    onCardClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val cardColor = if (isPressed) Orange else Color.White
    val textColor = if (isPressed) Color.White else Black
    val elevation = if (isPressed) 8.dp else 4.dp

    Card(
        elevation = CardDefaults.cardElevation(elevation),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        onClick = {
            isPressed = !isPressed
            onCardClick()
        },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(cardColor)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Column {
                infoItems.forEach { item ->
                    InfoRow(item = item, textColor = textColor)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
            IconButton(
                onClick = {
                    isPressed = !isPressed
                    onCardClick()
                }, modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Checkbox(
                    checked = isPressed, onCheckedChange = {
                        isPressed = it
                        onCardClick()
                    }, colors = CheckboxDefaults.colors(
                        checkedColor = textColor,
                        uncheckedColor = textColor,
                        checkmarkColor = Orange
                    )
                )
            }
        }
    }
}

@Composable
fun InfoRow(item: InfoItem, textColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = item.icon, contentDescription = null, tint = textColor)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = item.info, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview() {
    AgilMobileTheme {
        InfoCard(
            infoItems = listOf(
                InfoItem(Icons.Default.TravelExplore, "Zona Leste 1"),
                InfoItem(Icons.Default.LocationOn, "Ceps: 080 - 081 - 082 - 083"),
                InfoItem(Icons.Default.Apps, "Pacotes: 35")
            ),
            onCardClick = {},
        )
    }
}
