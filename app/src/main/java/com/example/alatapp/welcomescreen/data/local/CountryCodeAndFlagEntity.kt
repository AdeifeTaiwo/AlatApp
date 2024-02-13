package com.example.alatapp.welcomescreen.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.alatapp.welcomescreen.data.remote.Flags
import com.example.alatapp.welcomescreen.data.remote.Name
import com.example.alatapp.welcomescreen.data.remote.response.Idd

@Entity
data class CountryCodeAndFlagEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val flag: String,
    val flags: Flags,
    val idd: Idd,
    val name: Name,
)
