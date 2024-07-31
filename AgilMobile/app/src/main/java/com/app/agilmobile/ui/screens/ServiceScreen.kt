package com.app.agilmobile.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.components.drawer.DrawerContent
import com.app.agilmobile.ui.components.general.temporaries.FunUnderConstruction
import com.app.agilmobile.ui.components.navigation.ServiceBottomBar
import com.app.agilmobile.ui.components.navigation.TopBar
import com.app.agilmobile.ui.sections.deliveries.*
import com.app.agilmobile.ui.sections.deliveries.packages.PackagesSection
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.viewmodels.service.SectionService
import com.app.agilmobile.viewmodels.service.ServiceScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun ServiceScreen(navController: NavHostController, viewModel: ServiceScreenViewModel = viewModel()) {
    val currentSection by viewModel.currentSection
    val drawerState = rememberDrawerState(initialValue = viewModel.drawerState.value)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(viewModel.drawerState.value) {
        if (viewModel.drawerState.value == DrawerValue.Open) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(onClose = { viewModel.closeDrawer() })
        }, drawerState = drawerState, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(start = 4.dp, end = 4.dp)
        ) {
            TopBar(onMenuClick = {
                coroutineScope.launch {
                    if (drawerState.isClosed) {
                        viewModel.openDrawer()
                    } else {
                        viewModel.closeDrawer()
                    }
                }
            })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (currentSection) {
                    SectionService.MAINSCREEN -> MainScreen(navController)
                    SectionService.HOME -> HomeSection(navController)
                    SectionService.PACKAGES -> PackagesSection()
                    SectionService.FUNCTION_CONSTRUCTION -> FunUnderConstruction(navController)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            ServiceBottomBar(
                navController, onSectionSelected = viewModel::setSection
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceScreenPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        ServiceScreen(navController)
    }
}
