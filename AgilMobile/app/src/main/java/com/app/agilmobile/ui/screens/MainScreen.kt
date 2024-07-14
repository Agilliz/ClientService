package com.app.agilmobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsCompat
import com.app.agilmobile.ui.components.BottomBar
import com.app.agilmobile.ui.components.TopBar
import com.app.agilmobile.ui.theme.AgilMobileTheme

@Composable
fun MainScreen(){


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
            .windowInsetsPadding(insets = WindowInsets(top = 20.dp, bottom = 40.dp))

    ) {
        TopBar()
        Box(){

        }
        BottomBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    AgilMobileTheme {
        MainScreen()
    }
}