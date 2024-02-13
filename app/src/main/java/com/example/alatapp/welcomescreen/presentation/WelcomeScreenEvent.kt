package com.example.alatapp.welcomescreen.presentation

sealed class WelcomeScreenEvent {
    data class ShowHideCountryModal(val show: Boolean ) : WelcomeScreenEvent()
    object ProceedEvent: WelcomeScreenEvent()

}
