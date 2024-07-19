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
import com.app.agilmobile.ui.components.TopBar
import com.app.agilmobile.ui.routes.RoutesNavigationGraph
import com.app.agilmobile.ui.sections.EmptySection
import com.app.agilmobile.ui.sections.deliveries.*
import com.app.agilmobile.ui.sections.deliveries.packages.PackagesSection
import com.app.agilmobile.ui.theme.AgilMobileTheme
import kotlinx.coroutines.launch

enum class Section {
    HOME, SCRIPTS, PACKAGES, NEXT_DELIVERY, COMPLETE_DELIVERY, FUNCTION_CONSTRUCTION, EMPTY_SECTION
}

@Composable
fun MainScreen(navController: NavHostController) {
    var currentSection by remember { mutableStateOf(Section.HOME) }
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
                    Section.HOME -> HomeSection(navController)
                    Section.SCRIPTS -> ScriptsSection()
                    Section.PACKAGES -> PackagesSection()
                    Section.NEXT_DELIVERY -> NextDeliverySection()
                    Section.COMPLETE_DELIVERY -> CompleteDeliverySection()
                    Section.FUNCTION_CONSTRUCTION -> FunUnderConstruction(navController)
                    Section.EMPTY_SECTION -> EmptySection(navController)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            MainBottomBar(navController,
                onSectionSelected = { section -> currentSection = section })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        MainScreen(navController)
    }
}