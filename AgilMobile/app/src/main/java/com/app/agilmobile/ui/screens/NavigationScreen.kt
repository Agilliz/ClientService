package com.example.composeapp.ui.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.composeapp.ui.viewmodels.DeliveryItem
import com.example.composeapp.ui.viewmodels.NavigationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen(navController: NavController, viewModel: NavigationViewModel = viewModel()) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val deliveries by viewModel.deliveries

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 300.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            SheetContent(navController, deliveries)
        },
        content = { paddingValues ->
            MainContent(paddingValues)
        })
}

@Composable
fun SheetContent(navController: NavController, deliveries: List<DeliveryItem>) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .padding(vertical = 2.dp, horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Seg, 05 de Agosto", fontSize = 22.sp, fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Alterar Percurso",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Orange,
                    modifier = Modifier.clickable { navController.navigate("change_route_screen") }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .padding(10.dp)
            ) {
                Text(
                    text = "56 Paradas - 165 Km - 5h36m",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Otimizado por - 55 Km - 1h40m",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(intrinsicSize = IntrinsicSize.Min)
                        .background(Color.White)
                        .padding(10.dp)
                ) {
                    CardNextDeliverie(
                        id = "1",
                        address = "Rua Serra do Itaqueri",
                        number = "503",
                        neighborhood = "",
                        state = "",
                        zipCode = "08070-080",
                        time = "9:36",
                        onStartClick = { /* Ação para iniciar entrega */ },
                        onCompleteClick = { /* Ação para completar entrega */ }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Min)
                            .verticalScroll(scrollState)
                    ) {

                        deliveries.forEach { delivery ->
                            CardDeliverie(
                                id = delivery.id,
                                address = delivery.address,
                                number = delivery.number,
                                neighborhood = delivery.neighborhood,
                                state = delivery.state,
                                zipCode = delivery.zipCode,
                                time = delivery.time
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent(paddingValues: PaddingValues) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .padding(10.dp)
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            NavigationTopBar()
            NavigationBottomBar()
        }
    }
}

@Composable
fun NavigationTopBar() {
    var isExpanded by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(true) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp)
    ) {
        IconButton(
            onClick = { /* Add navigation logic here */ },
            modifier = Modifier.background(Orange, RoundedCornerShape(14.dp))
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        BalanceCard(isExpanded, isVisible) { isExpanded = !isExpanded }
    }
}

@Composable
fun BalanceCard(isExpanded: Boolean, isVisible: Boolean, onExpandToggle: () -> Unit) {
    var isVisible by remember { mutableStateOf(true) }

    Row(modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .background(Blue)
        .clickable { onExpandToggle() }
        .padding(14.dp)) {
        if (isExpanded) {
            Icon(
                imageVector = if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                contentDescription = "Icon Eye",
                tint = Color.White,
                modifier = Modifier.clickable { isVisible = !isVisible })
            Spacer(modifier = Modifier.width(5.dp))

            Box(
                modifier = Modifier
                    .height(25.dp)
                    .width(2.dp)
                    .background(Grey)
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
        Text(
            text = if (isVisible) "R$ 350,00" else "******",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = "Icon Arrow",
            tint = Color.White
        )
    }
}

@Composable
fun NavigationBottomBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp)
    ) {
        BottomBarButton(icon = Icons.Default.ControlCamera, description = "Back", color = Black)
        BottomBarButton(icon = Icons.Default.Add, description = "Add", color = Black)
    }
}

@Composable
fun BottomBarButton(icon: ImageVector, description: String, color: Color) {
    IconButton(
        onClick = { /* Add action logic here */ },
        modifier = Modifier.background(Grey, RoundedCornerShape(14.dp))
    ) {
        Icon(
            imageVector = icon, contentDescription = description, tint = color
        )
    }
}

@Composable
fun CardNextDeliverie(
    id: String,
    address: String,
    number: String,
    neighborhood: String,
    state: String,
    zipCode: String,
    time: String,
    startText: String = "Iniciar",
    completeText: String = "Concluído",
    onStartClick: () -> Unit = {},
    onCompleteClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.height(IntrinsicSize.Min)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = id, fontWeight = FontWeight.SemiBold, fontSize = 22.sp, color = Orange
            )
            Icon(
                imageVector = Icons.Default.Straight,
                contentDescription = "Icon NextDeliverie",
                modifier = Modifier.size(50.dp),
                tint = Orange30
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
                Row {
                    Text(
                        text = address, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = number, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                    )

                }
                Text(
                    text = time, fontSize = 18.sp, fontWeight = FontWeight.SemiBold
                )
            }
            Row {
                Text(
                    text = neighborhood , fontSize = 16.sp, fontWeight = FontWeight.Normal
                )
                Text(
                    text = state, fontSize = 16.sp, fontWeight = FontWeight.Normal
                )
                Text(
                    text = zipCode, fontSize = 16.sp, fontWeight = FontWeight.Normal
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Orange)
                        .clickable(onClick = onStartClick)
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = "Icon Navigation",
                        modifier = Modifier.size(20.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = startText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Blue)
                        .clickable(onClick = onCompleteClick)
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Icon Completed",
                        modifier = Modifier.size(20.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = completeText,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun CardDeliverie(
    id: String,
    address: String,
    number: String,
    neighborhood: String,
    state: String,
    zipCode: String,
    time: String
) {
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
                .background(Grey)
                .padding(6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = id,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Orange
                )
                Icon(
                    imageVector = Icons.Default.Straight,
                    contentDescription = "Icon NextDeliverie",
                    modifier = Modifier.size(35.dp),
                    tint = Orange30
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Row(modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max)) {
                            Text(
                                text = "$address, $number",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f, fill = true)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row (modifier = Modifier.width(200.dp)){
                            Text(
                                text = "$neighborhood, $state, $zipCode",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = time,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
        HorizontalLine()
    }
}


@Composable
fun HorizontalLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(Black30)
            .padding(6.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationScreenPreview() {
    val navController = rememberNavController()
    NavigationScreen(navController)
}
