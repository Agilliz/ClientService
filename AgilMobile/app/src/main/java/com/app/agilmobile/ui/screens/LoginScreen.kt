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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.app.agilmobile.ui.theme.Blue
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange

@Composable
fun LoginScreen() {
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
                text = "Login",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Blue,
            )
            Spacer(modifier = Modifier.height(60.dp))

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
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .border(1.dp, Black30, RoundedCornerShape(16.dp)),
                label = { Text("E-mail") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Icon User"
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),
            )

            Spacer(modifier = Modifier.height(22.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .border(1.dp, Black30, RoundedCornerShape(16.dp)),
                label = { Text("Senha") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Password,
                        contentDescription = "Icon Password"
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Esqueci a senha!",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Blue,
                modifier = Modifier
                    .align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(22.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange
                ),
                modifier = Modifier
                    .width(148.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
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