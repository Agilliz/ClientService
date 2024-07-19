package com.app.agilmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.screens.SectionService
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Orange

@Composable
fun ServiceBottomBar(
    navController: NavController, onSectionSelected: (SectionService) -> Unit
) {
    Box(
        modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()
    ) {
        // This Box is for the border effect
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Black30)
                .align(Alignment.TopCenter)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { navController.navigate("main_screen") }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.height(20.dp)
                )
                Text(
                    text = "Home", fontWeight = FontWeight.SemiBold, fontSize = 12.sp
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onSectionSelected(SectionService.PACKAGES) }) {
                Icon(
                    imageVector = Icons.Default.AllInbox,
                    contentDescription = "Entregas",
                    modifier = Modifier.height(20.dp)
                )
                Text(
                    text = "Entregas", fontWeight = FontWeight.SemiBold, fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(60.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onSectionSelected(SectionService.SCRIPTS) }) {
                Icon(
                    imageVector = Icons.Default.TextSnippet,
                    contentDescription = "Relatórios",
                    modifier = Modifier.height(20.dp)
                )
                Text(
                    text = "Relatórios", fontWeight = FontWeight.SemiBold, fontSize = 12.sp
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onSectionSelected(SectionService.COMPLETE_DELIVERY) }) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Vazio",
                    modifier = Modifier.height(20.dp)
                )
                Text(
                    text = "Vazio", fontWeight = FontWeight.SemiBold, fontSize = 12.sp
                )
            }
        }

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(66.dp)
                .offset(y = (-20).dp)
                .align(Alignment.TopCenter)
                .background(Orange, shape = CircleShape)
                .clickable { onSectionSelected(SectionService.NEXT_DELIVERY) }) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Localização",
                tint = Color.White,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceBottomBarPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        ServiceBottomBar(navController, onSectionSelected = {})
    }
}
