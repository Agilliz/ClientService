package com.app.agilmobile.ui.sections.deliveries

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.R
import com.app.agilmobile.ui.components.CardService
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Orange


@Composable
fun HomeSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Row {
                        Text(
                            text = "Bem Vindo, Carlos",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Icon(
                            imageVector = Icons.Default.ThumbUp,
                            contentDescription = "Icon Hello",
                            tint = Orange
                        )
                    }

                    Text(
                        text = "Vamos \nComeçar!",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 28.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painterResource(id = R.drawable.selfie),
                    contentDescription = "Selfie User",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Tipos de Serviços",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    CardService(
                        title = "Entregas",
                        imageResId = R.drawable.entregas,
                        icon = Icons.Default.ArrowForward,
                        onClick = {navController.navigate("service_screen")},
                        onSectionSelected = { navController.navigate("service_screen") },
                    )
                    CardService(
                        title = "Coletas",
                        imageResId = R.drawable.coletas,
                        icon = Icons.Default.ArrowForward,
                        onClick = {navController.navigate("service_screen")},
                        onSectionSelected = { navController.navigate("service_screen") },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeSectionPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        HomeSection(navController)
    }
}
