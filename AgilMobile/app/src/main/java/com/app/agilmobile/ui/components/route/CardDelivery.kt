package com.app.agilmobile.ui.components.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.components.general.dividers.VerticalLine
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange30

@Composable
fun CardDeliverie(
    id: String,
    icon: ImageVector,
    address: String,
    number: String,
    neighborhood: String,
    state: String,
    zipCode: String,
    time: String,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(Grey)
                .height(130.dp)
                .clickable(onClick = onClick)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon Deliverie",
                    modifier = Modifier.size(25.dp),
                    tint = Orange30
                )
                VerticalLine()
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column {
                        Row(modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max)) {
                            Text(
                                text = "$address, $number",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f, fill = true)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(modifier = Modifier.width(200.dp)) {
                            Text(
                                text = "$neighborhood, $state, $zipCode",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = time, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                        )
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Icon Check",
                            tint = Orange30,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}
