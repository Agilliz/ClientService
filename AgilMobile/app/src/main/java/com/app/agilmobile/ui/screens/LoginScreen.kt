package com.app.agilmobile.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.R
import com.app.agilmobile.ui.components.ButtonStandard
import com.app.agilmobile.ui.components.TextFieldStandard
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Black
import com.app.agilmobile.ui.theme.Blue
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange

@Composable
fun LoginScreen(navController: NavHostController) {

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)) +
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(durationMillis = 1000)
                ),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)) +
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(durationMillis = 1000)
                )
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
                    .fillMaxHeight()
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

                var email by remember {
                    mutableStateOf("")
                }

                var password by remember {
                    mutableStateOf("")
                }

                TextFieldStandard(
                    text = email,
                    onTextChange = { email = it },
                    label = "E-mail, Telefone ou Usuário",
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
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray,
                    modifier = Modifier.align(Alignment.End)
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