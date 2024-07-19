package com.app.agilmobile.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.components.DrawerContent
import com.app.agilmobile.ui.components.FunUnderConstruction
import com.app.agilmobile.ui.components.MainBottomBar
import com.app.agilmobile.ui.components.ServiceBottomBar
import com.app.agilmobile.ui.components.TopBar
import com.app.agilmobile.ui.routes.RoutesNavigationGraph
import com.app.agilmobile.ui.sections.deliveries.*
import com.app.agilmobile.ui.sections.deliveries.packages.PackagesSection
import com.app.agilmobile.ui.theme.AgilMobileTheme
import kotlinx.coroutines.launch

enum class SectionService {
    HOME, SCRIPTS, PACKAGES, NEXT_DELIVERY, COMPLETE_DELIVERY, MAINSCREEN, FUNCTION_CONSTRUCTION
}

@Composable
fun ServiceScreen(navController: NavHostController) {
    var currentSection by remember { mutableStateOf(SectionService.PACKAGES) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(onClose = { coroutineScope.launch { drawerState.close() } })
        }, drawerState = drawerState, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(start = 4.dp, end = 4.dp)
        ) {
            TopBar(onMenuClick = { coroutineScope.launch { drawerState.open() } })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when (currentSection) {
                    SectionService.MAINSCREEN -> MainScreen(navController)
                    SectionService.HOME -> HomeSection(navController)
                    SectionService.SCRIPTS -> ScriptsSection()
                    SectionService.PACKAGES -> PackagesSection()
                    SectionService.NEXT_DELIVERY -> NextDeliverySection()
                    SectionService.COMPLETE_DELIVERY -> CompleteDeliverySection()
                    SectionService.FUNCTION_CONSTRUCTION -> FunUnderConstruction(navController)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            ServiceBottomBar(navController,
                onSectionSelected = { SectionService -> currentSection = SectionService })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServiceScreenPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        MainScreen(navController)
    }
}