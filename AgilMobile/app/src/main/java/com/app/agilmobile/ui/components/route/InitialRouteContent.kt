package com.app.agilmobile.ui.components.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeapp.ui.viewmodels.DeliveryItem
import com.example.composeapp.ui.viewmodels.NavigationViewModel

@Composable
fun InitialRouteContent(
    navController: NavController,
    viewModel: NavigationViewModel = viewModel(),
    onItemClick: (DeliveryItem) -> Unit
) {
    val scrollState = rememberScrollState()
    val items = viewModel.combinedItems.value

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .padding(vertical = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "Seg, 05 de Agosto", fontSize = 22.sp, fontWeight = FontWeight.SemiBold
                )
                Text(text = "Alterar Percurso",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFA726), // Orange color
                    modifier = Modifier.clickable { navController.navigate("change_route_screen") })
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(10.dp)
            ) {
                Text(
                    text = "56 Paradas - 55 Km - 1h40m",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(6.dp))
                Column(
                    modifier = Modifier
                        .shadow(6.dp, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(Color.White)
                        .padding(6.dp)
                ) {

                    CardNextDeliverie(viewModel = viewModel)

                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .verticalScroll(scrollState)
                    ) {
                        items.forEach { item ->
                            CardDeliverie(id = item.id,
                                icon = viewModel.getIconForType(item.type),
                                address = item.address,
                                number = item.number,
                                neighborhood = item.neighborhood,
                                state = item.state,
                                zipCode = item.zipCode,
                                time = item.time,
                                onClick = { onItemClick(item) })
                        }
                    }
                }
            }
        }
    }
}
