package com.app.agilmobile.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
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
import com.app.agilmobile.ui.components.general.buttons.ButtonStandard
import com.app.agilmobile.ui.components.general.fields.TextFieldStandard
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange
import com.app.agilmobile.viewmodels.login.LoginViewModel

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = viewModel()) {
    val visible by viewModel.visible
    val email by viewModel.email
    val password by viewModel.password

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideInHorizontally(
            initialOffsetX = { it }, animationSpec = tween(durationMillis = 1000))
    ) {
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
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.agil_logistics_logo),
                    contentDescription = "Agil Logistics Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "Acesse sua conta",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray,
                )

                Spacer(modifier = Modifier.height(60.dp))

                TextFieldStandard(
                    text = email,
                    onTextChange = { viewModel.onEmailChange(it) },
                    label = "E-mail, Telefone ou Usuário",
                    leadingIcon = Icons.Default.AccountCircle
                )

                Spacer(modifier = Modifier.height(22.dp))

                TextFieldStandard(
                    text = password,
                    onTextChange = { viewModel.onPasswordChange(it) },
                    label = "Senha",
                    leadingIcon = Icons.Default.Info,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Esqueci a senha!",
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray,
                    modifier = Modifier.align(Alignment.End).clickable { navController.navigate("recovery_password") }
                )

                Spacer(modifier = Modifier.height(22.dp))

                ButtonStandard(
                    text = "Entrar",
                    onClick = { navController.navigate("main_screen") },
                    buttonColor = Orange,
                    textColor = Color.White,
                    cornerRadius = 12,
                )

                Text(
                    text = "Não tem acesso ? Cadastre-se",
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray,
                )
            }
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
