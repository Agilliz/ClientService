package com.app.agilmobile.ui.viewmodels

import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    val currentSection = mutableStateOf(Section.HOME)
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

    fun setSection(section: Section) {
        currentSection.value = section
    }
}

enum class Section {
    HOME, FUNCTION_CONSTRUCTION, EMPTY_SECTION, WALLET_SECTION
}