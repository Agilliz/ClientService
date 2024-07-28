package com.app.agilmobile.viewmodels.changeroutes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ChangeRouteViewModel : ViewModel() {

    val itemsInit = mutableStateOf(
        listOf(
            DeliverieItem("departure", "Rua A, 123", "11111-111"),
            DeliverieItem("fate", "Rua Z, 555", "11111-111"),
        )
    )

    val itemsStops = mutableStateOf(
        listOf(
            DeliverieItem(address = "Rua A, 123", zipCode = "11111-111"),
            DeliverieItem(address = "Rua Z, 555", zipCode = "11111-111"),
            DeliverieItem(address = "Rua A, 123", zipCode = "11111-111"),
            DeliverieItem(address = "Rua Z, 555", zipCode = "11111-111"),
            DeliverieItem(address = "Rua A, 123", zipCode = "11111-111"),
            DeliverieItem(address = "Rua Z, 555", zipCode = "11111-111"),
            DeliverieItem(address = "Rua A, 123", zipCode = "11111-111"),
            DeliverieItem(address = "Rua Z, 555", zipCode = "11111-111"),
            DeliverieItem(address = "Rua A, 123", zipCode = "11111-111"),
            DeliverieItem(address = "Rua Z, 555", zipCode = "11111-111"),
        )
    )

    fun getIconForType(type: String?): ImageVector {
        return when (type) {
            "departure" -> Icons.Default.Home
            "fate" -> Icons.Default.Flag
            else -> Icons.Default.LocationOn
        }
    }

    fun onEditClick(item: DeliverieItem) {
        viewModelScope.launch {
            // Lógica para editar
        }
    }

    fun onPrioritizeClick(item: DeliverieItem) {
        viewModelScope.launch {
            // Lógica para priorizar
        }
    }

    fun onDeleteClick(item: DeliverieItem) {
        viewModelScope.launch {
            // Lógica para excluir
        }
    }
}

data class DeliverieItem(val type: String? = null, val address: String, val zipCode: String)