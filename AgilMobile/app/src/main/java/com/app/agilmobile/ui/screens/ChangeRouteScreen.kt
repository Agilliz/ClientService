package com.app.agilmobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.components.changeroutes.ChangeableDeliveryCard
import com.app.agilmobile.ui.components.changeroutes.MicAndScannerField
import com.app.agilmobile.ui.theme.*
import com.app.agilmobile.viewmodels.changeroutes.ChangeRouteViewModel

@Composable
fun ChangeRouteScreen(navController: NavController, viewModel: ChangeRouteViewModel = viewModel()) {
    val scrollState = rememberScrollState()
    val itemsInit by viewModel.itemsInit
    val itemsStops by viewModel.itemsStops

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Grey)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            MicAndScannerField()

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Local de partida e término",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            itemsInit.forEach { item ->
                ChangeableDeliveryCard(
                    address = item.address,
                    zipCode = item.zipCode,
                    icon = viewModel.getIconForType(item.type),
                    onEditClick = { viewModel.onEditClick(item) },
                    onPrioritizeClick = { viewModel.onPrioritizeClick(item) },
                    onDeleteClick = { viewModel.onDeleteClick(item) }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Paradas", fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                itemsStops.forEach { item ->
                    ChangeableDeliveryCard(
                        address = item.address,
                        zipCode = item.zipCode,
                        icon = viewModel.getIconForType(item.type),
                        onEditClick = { viewModel.onEditClick(item) },
                        onPrioritizeClick = { viewModel.onPrioritizeClick(item) },
                        onDeleteClick = { viewModel.onDeleteClick(item) }
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = { /* Ação do botão flutuante */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(8.dp),
            containerColor = Orange,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 4.dp,
                pressedElevation = 6.dp
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Sync, contentDescription = "Icon Sync", tint = Color.White)
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Otimizar Rotas", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ChangeRouteScreenPreview() {
    val navController = rememberNavController()
    val viewModel = ChangeRouteViewModel()
    ChangeRouteScreen(navController = navController, viewModel = viewModel)
}