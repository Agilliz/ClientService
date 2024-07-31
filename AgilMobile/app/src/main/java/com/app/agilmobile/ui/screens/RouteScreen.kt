package com.example.composeapp.ui.screens

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.components.general.dividers.VerticalLine
import com.app.agilmobile.ui.components.general.fields.DeliveryTextField
import com.app.agilmobile.ui.components.navigation.NavigationTopBar
import com.app.agilmobile.ui.components.route.BottomSheetConfirmDelivery
import com.app.agilmobile.ui.components.route.BottomSheetNote
import com.app.agilmobile.ui.components.route.CardDeliverie
import com.app.agilmobile.ui.components.route.CardNextDeliverie
import com.app.agilmobile.ui.components.route.InitialRouteContent
import com.app.agilmobile.ui.theme.*
import com.example.composeapp.ui.viewmodels.DeliveryItem
import com.example.composeapp.ui.viewmodels.NavigationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteScreen(navController: NavController, viewModel: NavigationViewModel = viewModel()) {
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
                    InitialRouteContent(navController, onItemClick = { item ->
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
            BottomSheetConfirmDelivery(
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
            BottomSheetNote(onDismiss = { viewModel.closeNoteModal() })
        }

//        if (showCameraModal) {
//            CameraModal(onDismiss = { viewModel.closeCamera() })
//        }
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


@Preview(showBackground = true)
@Composable
fun NavigationScreenPreview() {
    val navController = rememberNavController()
    RouteScreen(navController)
}
