package com.example.composeapp.ui.screens

import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.components.ButtonStandard
import com.app.agilmobile.ui.components.TextFieldStandard
import com.app.agilmobile.ui.screens.FieldMicAndScanner
import com.app.agilmobile.ui.theme.*
import com.app.agilmobile.viewmodels.changeroutes.ChangeRouteViewModel
import com.example.composeapp.ui.viewmodels.DeliveryItem
import com.example.composeapp.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen(navController: NavController, viewModel: NavigationViewModel = viewModel()) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    var showSheetContent by remember { mutableStateOf(true) }
    var showSecondarySheet by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<DeliveryItem?>(null) }
    val showNoteModal by viewModel.isNoteModalOpen
    val showCameraModal by viewModel.isCameraOpen

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        MainContent(paddingValues = PaddingValues(0.dp))

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = if (showSheetContent) 250.dp else 0.dp,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                AnimatedVisibility(
                    visible = showSheetContent,
                    enter = fadeIn(animationSpec = tween(durationMillis = 400)) + slideInVertically(
                        initialOffsetY = { it }, animationSpec = tween(durationMillis = 400)
                    ),
                    exit = fadeOut(animationSpec = tween(durationMillis = 400)) + slideOutVertically(
                        targetOffsetY = { it }, animationSpec = tween(durationMillis = 400)
                    )
                ) {
                    SheetContent(navController, onItemClick = { item ->
                        selectedItem = item
                        showSecondarySheet = true
                        showSheetContent = false
                    })
                }
            },
            content = { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                }
            }
        )

        if (showSecondarySheet && selectedItem != null) {
            SecondaryBottomSheet(
                item = selectedItem!!,
                onDismiss = {
                    showSecondarySheet = false
                    showSheetContent = true
                },
                onOpenNoteModal = {
                    viewModel.openNoteModal()
                },
                onOpenCameraModal = {
                    viewModel.openCamera()
                }
            )
        }

        if (showNoteModal) {
            NoteModal(onDismiss = { viewModel.closeNoteModal() })
        }

//        if (showCameraModal) {
//            CameraModal(onDismiss = { viewModel.closeCamera() })
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryBottomSheet(
    item: DeliveryItem,
    onDismiss: () -> Unit,
    onOpenNoteModal: () -> Unit,
    onOpenCameraModal: () -> Unit,
    viewModel: NavigationViewModel = viewModel()
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val recipientName by viewModel.recipientName
    val recipientCpf by viewModel.recipientCpf
    val recipientRg by viewModel.recipientRg

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 650.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${item.address}, ${item.number}",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Icon Close",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .size(30.dp)
                                .background(Black30)
                                .padding(4.dp)
                        )
                    }
                }
                Column {
                    Text("${item.neighborhood}, ${item.state}, ${item.zipCode}", color = Black)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .shadow(6.dp, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(Color.White)
                        .padding(6.dp)
                ) {
                    Text(
                        text = "Destinatário",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Carlos Henrique Santos de Goes",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    TextFieldNavigation(
                        text = recipientName,
                        onTextChange = { viewModel.onRecipientName(it) },
                        label = "Nome recebedor",
                        leadingIcon = Icons.Default.People
                    )
                    TextFieldNavigation(
                        text = recipientCpf,
                        onTextChange = { viewModel.onRecipientCpf(it) },
                        label = "CPF",
                        leadingIcon = Icons.Default.Info
                    )
                    TextFieldNavigation(
                        text = recipientRg,
                        onTextChange = { viewModel.onRecipientRg(it) },
                        label = "RG",
                        leadingIcon = Icons.Default.Info
                    )

                    // Botão para abrir o modal de câmera
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Grey)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onOpenCameraModal() }
                                .padding(horizontal = 10.dp)
                                .height(60.dp)
                        ) {
                            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Icon Cam", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Comprovar entrega",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Gray
                            )
                        }
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Icon ArrowRight", tint = Color.DarkGray, modifier = Modifier.size(20.dp))
                    }

                    // Botão para abrir o modal de notas
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Grey)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onOpenNoteModal() }
                                .padding(horizontal = 10.dp)
                                .height(60.dp)
                        ) {
                            Icon(imageVector = Icons.Default.EditNote, contentDescription = "Icon Note", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Adicionar uma nota",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Gray
                            )
                        }
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Icon ArrowRight", tint = Color.DarkGray, modifier = Modifier.size(20.dp))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .shadow(4.dp)
                            .width(100.dp)
                            .fillMaxHeight()
                            .background(Orange)
                            .clickable(onClick = { /* Ação para iniciar entrega */ })
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Navigation,
                            contentDescription = "Icon Navigation",
                            modifier = Modifier.size(28.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Iniciar",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .fillMaxHeight()
                            .border(2.dp, Black30)
                            .shadow(54.dp)
                            .background(Grey)
                            .padding(10.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable(onClick = { /* Ação para iniciar entrega */ })
                                .fillMaxHeight()
                                .width(110.dp)
                        ) {
                            Box {
                                Icon(
                                    imageVector = Icons.Default.AllInbox,
                                    contentDescription = "Icon Not Completed",
                                    modifier = Modifier.size(28.dp),
                                    tint = Color.Gray
                                )
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = "Icon Close",
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .clip(RoundedCornerShape(30.dp))
                                        .size(20.dp)
                                        .background(Grey, shape = CircleShape),
                                    tint = Color.Red
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Cancelar",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Black
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        VerticalLine()

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable(onClick = { /* Ação para iniciar entrega */ })
                                .fillMaxHeight()
                                .width(120.dp)
                        ) {
                            Box {
                                Icon(
                                    imageVector = Icons.Default.AllInbox,
                                    contentDescription = "Icon Not Completed",
                                    modifier = Modifier.size(28.dp),
                                    tint = Color.Gray
                                )
                                Icon(
                                    imageVector = Icons.Filled.Check,
                                    contentDescription = "Icon Check",
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .clip(RoundedCornerShape(30.dp))
                                        .size(20.dp)
                                        .background(Grey, shape = CircleShape),
                                    tint = Color.Green
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Concluir",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Black
                            )
                        }
                    }
                }
            }
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                // Main content here
            }
        }
    )
}

@Composable
fun SheetContent(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteModal(onDismiss: () -> Unit, viewModel: NavigationViewModel = viewModel()) {
    val noteText by viewModel.noteText
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Adicionar Nota",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Icon Close",
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .size(30.dp)
                            .background(Black30)
                            .padding(4.dp)
                    )
                }
            }

            TextField(
                value = noteText,
                onValueChange = { viewModel.updateNoteText(it) },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(200.dp)
                    .padding(16.dp),
                placeholder = { Text("Digite sua nota aqui") },
                maxLines = 15,
                singleLine = false,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            ButtonStandard(
                text = "Salvar",
                onClick = { /*TODO*/ },
                buttonColor = Orange,
                textColor = Color.White,
                cornerRadius = 12
            )

        }
    }

    LaunchedEffect(viewModel.isNoteModalOpen.value) {
        if (!viewModel.isNoteModalOpen.value) {
            scope.launch { sheetState.hide() }
        }
    }
}



@Composable
fun MainContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        NavigationTopBar()

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .padding(10.dp)
        ) {
            Text(
                text = "Google Maps",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun NavigationTopBar() {
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
        FieldMicAndScanner()
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
    viewModel: NavigationViewModel = viewModel()
) {
    val currentDelivery = viewModel.currentDelivery

    if (currentDelivery != null) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(IntrinsicSize.Min)
            ) {
                Text(
                    text = currentDelivery.id,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Orange
                )
                Icon(
                    imageVector = Icons.Default.Straight,
                    contentDescription = "Icon NextDeliverie",
                    modifier = Modifier.size(35.dp),
                    tint = Orange30
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Row(modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max)) {
                                    Text(
                                        text = "${currentDelivery.address}, ${currentDelivery.number}",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))

                                Row(modifier = Modifier.width(200.dp)) {
                                    Text(
                                        text = "${currentDelivery.neighborhood}, ${currentDelivery.state}, ${currentDelivery.zipCode}",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                }
                            }

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .shadow(54.dp)
                                    .width(IntrinsicSize.Min)
                                    .background(Orange)
                                    .clickable(onClick = { /* Ação para iniciar entrega */ })
                                    .padding(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Navigation,
                                    contentDescription = "Icon Navigation",
                                    modifier = Modifier.size(26.dp),
                                    tint = Color.White
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Iniciar",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                    }
                }
            }
        }
    } else {
        Text(
            text = "Todas as entregas foram concluídas!",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Black30,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun CardDeliverie(
    id: String,
    icon: ImageVector,
    address: String,
    number: String,
    neighborhood: String,
    state: String,
    zipCode: String,
    time: String,
    onClick: () -> Unit
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
                .height(130.dp)
                .clickable(onClick = onClick)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon Deliverie",
                    modifier = Modifier.size(25.dp),
                    tint = Orange30
                )
                VerticalLine()
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
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
                        Row(modifier = Modifier.width(200.dp)) {
                            Text(
                                text = "$neighborhood, $state, $zipCode",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = time, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                        )
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Icon Check",
                            tint = Orange30,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldNavigation(
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
){
    TextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(Grey),
        label = { Text(
            text = label,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
        ) },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon, contentDescription = "Icon"
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
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

@Composable
fun VerticalLine() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(3.dp)
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
