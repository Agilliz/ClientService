package com.app.agilmobile.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.R
import com.app.agilmobile.ui.components.ButtonOrange
import com.app.agilmobile.ui.components.TextFieldStandard
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Black
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Blue
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange

@Composable
fun LoginScreen(navController: NavHostController) {

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        visible = true
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            AnimatedVisibility(
                visible = visible, enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 })
            ) {
                Image(
                    painter = painterResource(R.drawable.agil_logistics_logo),
                    contentDescription = "Agil Logistics Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }
            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Login",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Black,
            )

            Spacer(modifier = Modifier.height(60.dp))

            var email by remember {
                mutableStateOf("")
            }

            var password by remember {
                mutableStateOf("")
            }

            TextFieldStandard(
                text = email,
                onTextChange = { email = it },
                label = "E-mail",
                leadingIcon = Icons.Default.AccountCircle
            )

            Spacer(modifier = Modifier.height(22.dp))

            TextFieldStandard(
                text = password,
                onTextChange = { password = it },
                label = "Senha",
                leadingIcon = Icons.Default.Info,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Esqueci a senha!",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Blue,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(22.dp))

            ButtonOrange(
                text = "Entrar",
                fontSize = 26,
                padding = 8,
                onClick = { navController.navigate("mainScreen") },
                buttonColor = Orange,
                textColor = Color.White,
                buttonWidth = 148,
                buttonHeight = 68,
                cornerRadius = 12,
                defaultElevation = 4,
                pressedElevation = 6,

                )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}