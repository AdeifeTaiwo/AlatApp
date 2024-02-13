package com.example.alatapp.welcomescreen.data.remote.response

data class CountryWithCodeResponseItem(
    val capital: List<String>,
    val flag: String,
    val flags: Flags,
    val idd: Idd,
    val name: Name,
)