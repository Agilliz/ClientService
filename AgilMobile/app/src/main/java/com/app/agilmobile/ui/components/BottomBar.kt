package com.app.agilmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.FilePresent
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.RepeatOneOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Orange

@Composable
fun BottomBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp)
    ) {
        Box {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Localized description"
                    )
                }
                Text(
                    text = "Home",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp

                )
            }
        }

        Box {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AllInbox,
                        contentDescription = "Localized description"
                    )
                }
                Text(
                    text = "Entregas",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp

                )
            }
        }



        Box(
            modifier = Modifier
                .size(66.dp)
                .background(Orange, shape = CircleShape)
        ) {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Localized description",
                    tint = Color.White,
                    modifier = Modifier
                        .width(80.dp)
                )
            }
        }


        Box {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FilePresent,
                        contentDescription = "Localized description"
                    )
                }
                Text(
                    text = "Relatórios",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp

                )
            }
        }

        Box {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .height(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.QuestionMark,
                        contentDescription = "Localized description"
                    )
                }
                Text(
                    text = "Vazio",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    AgilMobileTheme {
        BottomBar()
    }
}
