package com.app.agilmobile.viewmodels.sheets

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondarySheetViewModel: ViewModel() {
    val visible = mutableStateOf(false)

    init {
        showAnimation()
    }

    private fun showAnimation() {
        viewModelScope.launch {
            delay(500)
            visible.value = true
        }
    }
}