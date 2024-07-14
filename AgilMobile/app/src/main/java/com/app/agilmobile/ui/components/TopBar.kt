    package com.app.agilmobile.ui.components

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Chat
    import androidx.compose.material.icons.filled.Menu
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.app.agilmobile.ui.theme.AgilMobileTheme
    import com.app.agilmobile.ui.theme.Orange


    @Composable
    fun TopBar() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(8.dp)
        )
        {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Localized description"
                )
            }



            IconButton(
                onClick = { },
                modifier = Modifier
                    .background(Orange, RoundedCornerShape(14.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.Chat,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TopBarPreview() {
        AgilMobileTheme {
            TopBar()
        }
    }