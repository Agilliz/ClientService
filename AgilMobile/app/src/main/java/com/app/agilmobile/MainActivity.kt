package com.app.agilmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.agilmobile.ui.screens.LoginScreen
import com.app.agilmobile.ui.screens.MainScreen
import com.app.agilmobile.ui.theme.AgilMobileTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgilMobileTheme {
                    MainScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AgilMobilePreview() {
    AgilMobileTheme {
        LoginScreen()
    }
}