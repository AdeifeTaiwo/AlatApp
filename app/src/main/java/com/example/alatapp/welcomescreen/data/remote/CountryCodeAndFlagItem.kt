package com.example.alatapp.welcomescreen.data.remote

import com.example.alatapp.welcomescreen.data.remote.response.Idd

data class CountryCodeAndFlagItem(
    val capital: List<String>? = emptyList(),
    val flag: String,
    val flags: Flags,
    val idd: Idd,
    val name: Name,
)
