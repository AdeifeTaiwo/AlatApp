package com.example.alatapp.welcomescreen.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters


@Database(
    entities = [CountryCodeAndFlagEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CountryCodeAndFlagDatabase : RoomDatabase() {
    abstract val countryCodeAndFlagDao: CountryCodeAndFlagDao
}