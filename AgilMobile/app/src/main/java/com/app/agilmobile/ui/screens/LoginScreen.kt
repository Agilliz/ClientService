package com.app.agilmobile.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.app.agilmobile.R
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.agil_logistics_logo),
                contentDescription = "Agil Logistics Logo",
                modifier = Modifier
                    .size(300.dp)
                    .height(50.dp)
            )
            Text(
                text = "Login",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            var email by remember {
                mutableStateOf("")
            }

            var password by remember {
                mutableStateOf("")
            }

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Grey, RoundedCornerShape(8.dp))
                    .background(Color.Transparent, RoundedCornerShape(8.dp)),
            label = { Text("E-mail") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Icon User"
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Orange
                )
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Grey, RoundedCornerShape(8.dp)),
                label = { Text("Senha") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Password,
                        contentDescription = "Icon Password"
                    )
                },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color.Transparent,
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Text(
                text = "Esqueci a senha!",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .align(Alignment.End)
            )



            Button(
                onClick = { /* Ação de login */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange
                ),
                modifier = Modifier
                    .width(148.dp)
                    .height(48.dp)


            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AgilMobileTheme {
        LoginScreen()
    }
}