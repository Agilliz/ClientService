package com.app.agilmobile.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.components.BottomBar
import com.app.agilmobile.ui.components.TopBar
import com.app.agilmobile.ui.sections.deliveries.*
import com.app.agilmobile.ui.sections.deliveries.packages.PackagesSection
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Orange30

enum class Section {
    HOME, SCRIPTS, PACKAGES, NEXT_DELIVERY, COMPLETE_DELIVERY
}

@Composable
fun MainScreen(navController: NavHostController) {
    var currentSection by remember { mutableStateOf(Section.HOME) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(start = 4.dp, end = 4.dp)
    ) {
        TopBar()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
//                .border(2.dp, Orange30, RoundedCornerShape(16.dp))
                .padding(4.dp)
        ) {
            when (currentSection) {
                Section.HOME -> HomeSection()
                Section.SCRIPTS -> ScriptsSection()
                Section.PACKAGES -> PackagesSection()
                Section.NEXT_DELIVERY -> NextDeliverySection()
                Section.COMPLETE_DELIVERY -> CompleteDeliverySection()
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        BottomBar(onSectionSelected = { currentSection = it })
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