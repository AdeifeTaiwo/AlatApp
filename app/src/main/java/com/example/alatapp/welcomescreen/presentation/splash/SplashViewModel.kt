package com.example.alatapp.welcomescreen.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _showSplashScreen = MutableStateFlow(true)
    val showSplashScreen : StateFlow<Boolean> = _showSplashScreen.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            _showSplashScreen.value = false
        }
    }
}