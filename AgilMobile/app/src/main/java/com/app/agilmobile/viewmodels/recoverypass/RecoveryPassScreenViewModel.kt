package com.app.agilmobile.viewmodels.recoverypass

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RecoveryPassViewModel : ViewModel() {
    val email = mutableStateOf("")
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

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }
}
