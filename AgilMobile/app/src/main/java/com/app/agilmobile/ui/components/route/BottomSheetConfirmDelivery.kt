package com.app.agilmobile.ui.components.route

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.agilmobile.ui.components.general.dividers.VerticalLine
import com.app.agilmobile.ui.components.general.fields.DeliveryTextField
import com.app.agilmobile.ui.theme.Black
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange
import com.example.composeapp.ui.viewmodels.DeliveryItem
import com.example.composeapp.ui.viewmodels.NavigationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetConfirmDelivery(
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
                        fontSize = 24.sp,
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
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    ) {
                        DeliveryTextField(
                            text = recipientName,
                            onTextChange = { viewModel.onRecipientName(it) },
                            label = "Nome recebedor",
                            leadingIcon = Icons.Default.People
                        )
                        DeliveryTextField(
                            text = recipientCpf,
                            onTextChange = { viewModel.onRecipientCpf(it) },
                            label = "CPF",
                            leadingIcon = Icons.Default.Info
                        )
                        DeliveryTextField(
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
                                Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "Icon Cam", tint = Color.DarkGray, modifier = Modifier.size(25.dp))
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(
                                    text = "Comprovar entrega",
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Gray
                                )
                            }
                            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Icon ArrowRight", tint = Color.DarkGray, modifier = Modifier.size(25.dp))
                        }

                        // Botão para abrir o modal de notas
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Grey)
                                .clickable { onOpenNoteModal() }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 10.dp)
                                    .height(60.dp)
                            ) {
                                Icon(imageVector = Icons.Default.EditNote, contentDescription = "Icon Note", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(
                                    text = "Adicionar uma nota",
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Gray
                                )
                            }
                            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Icon ArrowRight", tint = Color.DarkGray, modifier = Modifier.size(20.dp))
                        }
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
