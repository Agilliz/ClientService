package com.example.composeapp.ui.viewmodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.StopCircle
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class DeliveryItem(
    val type: String,
    val id: String,
    val address: String,
    val number: String,
    val neighborhood: String,
    val state: String,
    val zipCode: String,
    val time: String,
    var status: DeliveryStatus = DeliveryStatus.PENDING
)

enum class DeliveryStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}

class NavigationViewModel : ViewModel() {
    val recipientName = mutableStateOf("")
    val recipientCpf = mutableStateOf("")
    val recipientRg = mutableStateOf("")

    val isNoteModalOpen = mutableStateOf(false)
    val isCameraOpen = mutableStateOf(false)
    val noteText = mutableStateOf("")

    fun onRecipientName(recipient: String) {
        recipientName.value = recipient
    }

    fun onRecipientCpf(cpf: String) {
        recipientCpf.value = cpf
    }

    fun onRecipientRg(rg: String) {
        recipientRg.value = rg
    }

    fun openNoteModal() {
        isNoteModalOpen.value = true
    }

    fun closeNoteModal() {
        isNoteModalOpen.value = false
    }

    fun updateNoteText(text: String) {
        noteText.value = text
    }

    fun openCamera() {
        isCameraOpen.value = true
    }

    fun closeCamera() {
        isCameraOpen.value = false
    }

    val combinedItems = mutableStateOf(
        listOf(
            DeliveryItem("departure", "01", "Rua Serra do Itaqueri", "503", "Ermelino Matarazzo", "São Paulo", "08070-080", "09:36"),
            DeliveryItem("stop", "03", "Rua B", "503", "Ermelino Matarazzo", "São Paulo", "22222-222", "09:15"),
            DeliveryItem("stop", "04", "Rua C", "503", "Ermelino Matarazzo", "São Paulo", "33333-333", "09:30"),
            DeliveryItem("stop", "05", "Rua D", "503", "Ermelino Matarazzo", "São Paulo", "44444-444", "09:45"),
            DeliveryItem("stop", "06", "Rua E", "503", "Ermelino Matarazzo", "São Paulo", "55555-555", "10:00"),
            DeliveryItem("stop", "07", "Rua F", "503", "Ermelino Matarazzo", "São Paulo", "66666-666", "10:15"),
            DeliveryItem("stop", "08", "Rua G", "503", "Ermelino Matarazzo", "São Paulo", "77777-777", "10:30"),
            DeliveryItem("stop", "09", "Rua H", "503", "Ermelino Matarazzo", "São Paulo", "88888-888", "10:45"),
            DeliveryItem("stop", "10", "Rua I", "503", "Ermelino Matarazzo", "São Paulo", "99999-999", "11:00"),
            DeliveryItem("stop", "11", "Rua J", "503", "Ermelino Matarazzo", "São Paulo", "00000-000", "11:15"),
            DeliveryItem("fate", "02", "Rua da Mooca", "222", "Mooca", "São Paulo", "99999-999", "09:36")
        )
    )

    val currentDeliveryIndex = mutableStateOf(0)
    val completedDeliveries = mutableStateOf(listOf<DeliveryItem>())

    fun getIconForType(type: String?): ImageVector {
        return when (type) {
            "departure" -> Icons.Default.Home
            "fate" -> Icons.Default.Flag
            else -> Icons.Default.StopCircle
        }
    }

    val currentDelivery: DeliveryItem?
        get() = combinedItems.value.getOrNull(currentDeliveryIndex.value)

    fun onCompleteClick() {
        viewModelScope.launch {
            val currentIndex = currentDeliveryIndex.value
            if (currentIndex < combinedItems.value.size) {
                val currentDelivery = combinedItems.value[currentIndex]
                currentDelivery.status = DeliveryStatus.COMPLETED
                completedDeliveries.value = completedDeliveries.value + currentDelivery
                currentDeliveryIndex.value = currentIndex + 1
            }
        }
    }
}
