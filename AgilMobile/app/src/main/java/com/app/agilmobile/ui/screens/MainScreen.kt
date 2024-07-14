package com.app.agilmobile.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.agilmobile.ui.components.BottomBar
import com.app.agilmobile.ui.components.TopBar
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Orange30

@Composable
fun MainScreen() {
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
                .border(2.dp, Orange30, RoundedCornerShape(16.dp))
                .padding(4.dp)
        ) {

        }
        Spacer(modifier = Modifier.height(4.dp))
        BottomBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AgilMobileTheme {
        MainScreen()
    }
}
