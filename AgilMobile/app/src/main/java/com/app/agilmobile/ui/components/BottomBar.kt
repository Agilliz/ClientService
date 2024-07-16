package com.app.agilmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.screens.Section
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Orange
import com.app.agilmobile.ui.theme.Orange30

@Composable
fun BottomBar(onSectionSelected: (Section) -> Unit) {
    Box(
        modifier = Modifier
            .height(65.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent)
                .border(2.dp, Orange30, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onSectionSelected(Section.HOME) }
            ) {
                IconButton(
                    onClick = { onSectionSelected(Section.HOME) },
                    modifier = Modifier.height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home"
                    )
                }
                Text(
                    text = "Home",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onSectionSelected(Section.PACKAGES) }
            ) {
                IconButton(
                    onClick = { onSectionSelected(Section.PACKAGES) },
                    modifier = Modifier.height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Entregas"
                    )
                }
                Text(
                    text = "Entregas",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(60.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onSectionSelected(Section.NEXT_DELIVERY) }
            ) {
                IconButton(
                    onClick = { onSectionSelected(Section.NEXT_DELIVERY) },
                    modifier = Modifier.height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Relatórios"
                    )
                }
                Text(
                    text = "Relatórios",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onSectionSelected(Section.COMPLETE_DELIVERY) }
            ) {
                IconButton(
                    onClick = { onSectionSelected(Section.COMPLETE_DELIVERY) },
                    modifier = Modifier.height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Vazio"
                    )
                }
                Text(
                    text = "Vazio",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(66.dp)
                .offset(y = (-20).dp)
                .align(Alignment.TopCenter)
                .background(Orange, shape = CircleShape)
                .clickable { onSectionSelected(Section.NEXT_DELIVERY) }
        ) {
            IconButton(
                onClick = { onSectionSelected(Section.NEXT_DELIVERY) }
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Localização",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    AgilMobileTheme {
        BottomBar(onSectionSelected = {})
    }
}
