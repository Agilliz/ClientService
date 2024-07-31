package com.app.agilmobile.ui.components.changeroutes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flip
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Blue

@Composable
fun MicAndScannerField() {

    TextField(
        value = "",
        onValueChange = { /* Lógica para atualizar o texto */ },
        label = { Text(text = "Informe novo endereço") },
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .fillMaxWidth()
            .height(65.dp)
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Black30, RoundedCornerShape(14.dp)),
        trailingIcon = {
            Row {
                IconButton(
                    onClick = { /* Ação do ícone de microfone */ }, modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Flip,
                        contentDescription = "Icon Mic",
                        tint = Blue
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = { /* Ação do ícone de microfone */ }, modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Mic,
                        contentDescription = "Icon Mic",
                        tint = Blue
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
            }

        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp)
    )

}