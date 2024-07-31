package com.app.agilmobile.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.R
import com.app.agilmobile.ui.components.navigation.ArrowBackTopBar
import com.app.agilmobile.ui.components.general.buttons.ButtonStandard
import com.app.agilmobile.ui.components.general.fields.TextFieldStandard
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange
import com.app.agilmobile.viewmodels.recoverypass.RecoveryPassViewModel

@Composable
fun RecoveryPassScreen(navController: NavHostController, viewModel: RecoveryPassViewModel = viewModel()) {
    val email by viewModel.email
    val visible by viewModel.visible

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideInHorizontally(
            initialOffsetX = { it }, animationSpec = tween(durationMillis = 1000)
        ),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)) + slideOutHorizontally(
            targetOffsetX = { it }, animationSpec = tween(durationMillis = 1000)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Grey)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                ArrowBackTopBar(navController)

                Image(
                    painter = painterResource(R.drawable.agil_logistics_logo),
                    contentDescription = "Agil Logistics Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Recuperar Senha",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Por favor, insira seu endereço de e-mail. Você receberá um link para criar uma nova senha!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextFieldStandard(
                    text = email,
                    onTextChange = { viewModel.onEmailChange(it) },
                    label = "E-mail",
                    leadingIcon = Icons.Default.AccountCircle
                )

                Spacer(modifier = Modifier.height(16.dp))

                ButtonStandard(
                    text = "Enviar",
                    onClick = { navController.navigate("login") },
                    buttonColor = Orange,
                    textColor = Color.White,
                    cornerRadius = 12,
                )

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecoveryPassScreenPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        RecoveryPassScreen(navController)
    }
}
