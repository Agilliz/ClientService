package com.app.agilmobile.ui.components.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Straight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Orange
import com.app.agilmobile.ui.theme.Orange30
import com.example.composeapp.ui.viewmodels.NavigationViewModel

@Composable
fun CardNextDeliverie(
    viewModel: NavigationViewModel = viewModel()
) {
    val currentDelivery = viewModel.currentDelivery

    if (currentDelivery != null) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(IntrinsicSize.Min)
            ) {
                Text(
                    text = currentDelivery.id,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Orange
                )
                Icon(
                    imageVector = Icons.Default.Straight,
                    contentDescription = "Icon NextDeliverie",
                    modifier = Modifier.size(35.dp),
                    tint = Orange30
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Row(modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max)) {
                                    Text(
                                        text = "${currentDelivery.address}, ${currentDelivery.number}",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))

                                Row(modifier = Modifier.width(200.dp)) {
                                    Text(
                                        text = "${currentDelivery.neighborhood}, ${currentDelivery.state}, ${currentDelivery.zipCode}",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                }
                            }

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .shadow(54.dp)
                                    .width(IntrinsicSize.Min)
                                    .background(Orange)
                                    .clickable(onClick = { /* Ação para iniciar entrega */ })
                                    .padding(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Navigation,
                                    contentDescription = "Icon Navigation",
                                    modifier = Modifier.size(26.dp),
                                    tint = Color.White
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Iniciar",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                    }
                }
            }
        }
    } else {
        Text(
            text = "Todas as entregas foram concluídas!",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Black30,
            modifier = Modifier.padding(16.dp)
        )
    }
}
