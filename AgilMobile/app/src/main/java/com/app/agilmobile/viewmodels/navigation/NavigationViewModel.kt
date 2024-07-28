package com.example.composeapp.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NavigationViewModel : ViewModel() {
    val deliveries = mutableStateOf(
        listOf(
            DeliveryItem("01", "Rua Serra do Itaqueri", "503", "Ermelino Matarazzo", "São Paulo", "08070-080", "09:36"),
            DeliveryItem("03", "Rua B", "503", "Ermelino Matarazzo", "São Paulo", "22222-222", "09:15"),
            DeliveryItem("04", "Rua C", "503", "Ermelino Matarazzo", "São Paulo", "33333-333", "09:30"),
            DeliveryItem("05", "Rua D", "503", "Ermelino Matarazzo", "São Paulo", "44444-444", "09:45"),
            DeliveryItem("06", "Rua E", "503", "Ermelino Matarazzo", "São Paulo", "55555-555", "10:00"),
            DeliveryItem("07", "Rua F", "503", "Ermelino Matarazzo", "São Paulo", "66666-666", "10:15"),
            DeliveryItem("08", "Rua G", "503", "Ermelino Matarazzo", "São Paulo", "77777-777", "10:30"),
            DeliveryItem("09", "Rua H", "503", "Ermelino Matarazzo", "São Paulo", "88888-888", "10:45"),
            DeliveryItem("10", "Rua I", "503", "Ermelino Matarazzo", "São Paulo", "99999-999", "11:00"),
            DeliveryItem("11", "Rua J", "503", "Ermelino Matarazzo", "São Paulo", "00000-000", "11:15")
        )
    )

    val completedDeliveries = mutableStateOf(listOf<DeliveryItem>())

    fun onStartClick(item: DeliveryItem) {
        viewModelScope.launch {
            // Lógica para iniciar entrega
        }
    }

    fun onCompleteClick(item: DeliveryItem) {
        viewModelScope.launch {
            // Adiciona à lista de concluídos e remove da lista de entregas pendentes
            deliveries.value = deliveries.value.filter { it.id != item.id }
            completedDeliveries.value = completedDeliveries.value + item
        }
    }
}

data class DeliveryItem(val id: String, val address: String, val number: String, val neighborhood: String, val state: String, val zipCode: String, val time: String)
