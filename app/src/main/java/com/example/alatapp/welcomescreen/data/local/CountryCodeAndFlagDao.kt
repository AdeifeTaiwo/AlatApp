package com.example.alatapp.welcomescreen.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert


@Dao
interface CountryCodeAndFlagDao {
    //if its not there insert,
    // if its there update it
    @Upsert
    suspend fun upsertCountryCodeAndFlagList(movieList: List<CountryCodeAndFlagEntity>)


    @Query("SELECT * FROM CountryCodeAndFlagEntity")
    suspend fun getAllCountryCodeAndFlag() : List<CountryCodeAndFlagEntity>
}