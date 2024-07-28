package com.app.agilmobile.viewmodels.service

import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.DrawerValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ServiceScreenViewModel : ViewModel() {
    val currentSection = mutableStateOf(SectionService.PACKAGES)
    val drawerState = mutableStateOf(DrawerValue.Closed)

    fun openDrawer() {
        viewModelScope.launch {
            drawerState.value = DrawerValue.Open
        }
    }

    fun closeDrawer() {
        viewModelScope.launch {
            drawerState.value = DrawerValue.Closed
        }
    }

    fun setSection(section: SectionService) {
        currentSection.value = section
    }
}

enum class SectionService {
    HOME, PACKAGES, MAINSCREEN, FUNCTION_CONSTRUCTION
}
