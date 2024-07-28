package com.app.agilmobile.viewmodels.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")
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

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }
}
