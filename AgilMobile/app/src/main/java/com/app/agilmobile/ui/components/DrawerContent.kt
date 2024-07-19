package com.app.agilmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerContent(onClose: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(Color.White)
            .padding(vertical = 10.dp)

    ) {
        IconButton(
            onClick = onClose, modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close, contentDescription = "Close"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.weight(1f).fillMaxWidth()
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(imageVector = Icons.Default.Home, contentDescription = "Icon Home")
                Text(text = "Home", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(imageVector = Icons.Default.Notifications, contentDescription = "Icon Notification")
                Text(text = "Notificações", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
            }


            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(imageVector = Icons.Default.Groups, contentDescription = "Icon Groups")
                Text(text = "Parceiros", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(imageVector = Icons.Default.DirectionsCar, contentDescription = "Icon Car")
                Text(text = "Veículo", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Icon Settings")
                Text(text = "Preferências", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Icon Account")
                Text(text = "Conta", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
            }
        }


        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp)
        ){
            Icon(imageVector = Icons.Default.Logout, contentDescription = "Icon Logout")
            Text(text = "Sair", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
        }


    }
}