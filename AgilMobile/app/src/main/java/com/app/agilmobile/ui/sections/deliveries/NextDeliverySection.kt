package com.app.agilmobile.ui.sections.deliveries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.app.agilmobile.ui.theme.AgilMobileTheme

@Composable
fun NextDeliverySection(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Yellow)
    ) {
        Text(text = "Seção Próxima Entrega")
    }
}

@Preview(showBackground = true)
@Composable
fun NextDeliverySectionPreview() {
    AgilMobileTheme {
        NextDeliverySection()
    }
}