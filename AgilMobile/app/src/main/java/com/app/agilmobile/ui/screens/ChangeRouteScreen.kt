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
            FieldMicAndScanner()

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Local de partida e término",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            itemsInit.forEach { item ->
                CardDeliverieChangeable(
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
                    CardDeliverieChangeable(
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

@Composable
fun FieldMicAndScanner(){
    TextField(
        value = "",
        onValueChange = { /* Lógica para atualizar o texto */ },
        label = { Text(text = "Informe novo endereço") },
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .fillMaxWidth()
            .height(65.dp)
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Black30, RoundedCornerShape(14.dp)),
        trailingIcon = {
            Row {
                IconButton(
                    onClick = { /* Ação do ícone de microfone */ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(imageVector = Icons.Default.Flip, contentDescription = "Icon Mic", tint = Blue)
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = { /* Ação do ícone de microfone */ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(imageVector = Icons.Default.Mic, contentDescription = "Icon Mic", tint = Blue)
                }
                Spacer(modifier = Modifier.width(10.dp))
            }

        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun CardDeliverieChangeable(
    address: String,
    zipCode: String,
    icon: ImageVector,
    onEditClick: () -> Unit,
    onPrioritizeClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(Color.White)
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon NextDeliverie",
                    modifier = Modifier.size(30.dp),
                    tint = Orange
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = address, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = zipCode, fontSize = 12.sp, fontWeight = FontWeight.Normal
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        IconButton(onClick = { expanded = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreHoriz,
                                contentDescription = "Icon Three points"
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(text = { Text("Editar") }, onClick = onEditClick)
                            DropdownMenuItem(text = { Text("Priorizar") }, onClick = onPrioritizeClick)
                            DropdownMenuItem(text = { Text("Excluir") }, onClick = onDeleteClick)
                        }
                    }
                }
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