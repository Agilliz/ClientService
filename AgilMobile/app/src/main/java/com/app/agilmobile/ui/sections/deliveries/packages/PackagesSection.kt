package com.app.agilmobile.ui.sections.deliveries.packages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.agilmobile.ui.components.ButtonOrange
import com.app.agilmobile.ui.components.InfoCard
import com.app.agilmobile.ui.components.InfoItem
import com.app.agilmobile.ui.components.SearchBar
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange

enum class PackageStatus {
    PENDING, COMPLETED
}

@Composable
fun PackagesSection() {
    data class InfoCardData(val title: String, val cep: String, val packages: String)

    var selectedStatus by remember { mutableStateOf(PackageStatus.PENDING) }
    var searchQuery by remember { mutableStateOf("") }
    val pendingPackages = listOf(
        InfoCardData("Zona Leste 1", "080 - 081 - 082 - 083", "35"),
        InfoCardData("Zona Leste 2", "084 - 085 - 086 - 087", "62"),
        InfoCardData("Zona Leste 3", "034 - 035 - 036 - 037", "62"),
        InfoCardData("Zona Leste 4", "044 - 045 - 046 - 047", "62"),
    )
    val completedPackages = listOf(
        InfoCardData("Zona Leste 1", "080 - 081 - 082 - 083", "35"),
        InfoCardData("Zona Leste 2", "084 - 085 - 086 - 087", "62"),
        InfoCardData("Zona Leste 3", "034 - 035 - 036 - 037", "62"),
        InfoCardData("Zona Leste 4", "044 - 045 - 046 - 047", "62"),
    )

    val filterPackages = if (selectedStatus == PackageStatus.PENDING) {
        pendingPackages.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.cep.contains(searchQuery, ignoreCase = true)
        }
    } else {
        completedPackages.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.cep.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row {
            Text(text = "Pacotes a serem entregues")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Pendentes",
                fontSize = 30.sp,
                color = if (selectedStatus == PackageStatus.PENDING) Orange else Grey,
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedStatus = PackageStatus.PENDING }
                    .padding(8.dp)
            )
            Text(
                text = "Finalizados",
                fontSize = 30.sp,
                color = if (selectedStatus == PackageStatus.COMPLETED) Orange else Grey,
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedStatus = PackageStatus.COMPLETED }
                    .padding(8.dp)
            )
        }


        SearchBar(
            searchQuery = searchQuery,
            onSearchQueryChanged = { searchQuery = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            filterPackages.forEach { packageData ->
                Spacer(modifier = Modifier.height(12.dp))
                InfoCard(
                    infoItems = listOf(
                        InfoItem(Icons.Default.TravelExplore, packageData.title),
                        InfoItem(Icons.Default.LocationOn, "Ceps: ${packageData.cep}"),
                        InfoItem(Icons.Default.Apps, "Pacotes: ${packageData.packages}")
                    ),
                    onCardClick = {},
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Min)
                .padding(12.dp)
        ) {
            ButtonOrange(
                text = "Adicionar",
                fontSize = 16,
                padding = 0,
                onClick = { /**/ },
                buttonColor = Orange,
                textColor = Color.White,
                buttonWidth = 126,
                buttonHeight = 40,
                cornerRadius = 6,
                defaultElevation = 8,
                pressedElevation = 4
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PackagesSectionPreview() {
    AgilMobileTheme {
        PackagesSection()
    }
}
