package com.example.alatapp.welcomescreen.data.local

import androidx.room.TypeConverter
import com.example.alatapp.welcomescreen.data.remote.Flags
import com.example.alatapp.welcomescreen.data.remote.Name
import com.example.alatapp.welcomescreen.data.remote.response.Idd
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    //Flag type converter
    @TypeConverter
    fun fromFlag(flags: Flags?): String? {
        val type = object : TypeToken<Flags>() {}.type
        return Gson().toJson(flags, type)
    }
    @TypeConverter
    fun toFlags(flagsString: String?): Flags? {
        val type = object : TypeToken<Flags>() {}.type
        return Gson().fromJson<Flags>(flagsString, type)
    }


    //Idd type converter
    @TypeConverter
    fun fromIdd(idd: Idd?): String? {
        val type = object : TypeToken<Idd>() {}.type
        return Gson().toJson(idd, type)
    }
    @TypeConverter
    fun toIdd(iddString: String?): Idd? {
        val type = object : TypeToken<Idd>() {}.type
        return Gson().fromJson<Idd>(iddString, type)
    }


    //Name
    @TypeConverter
    fun fromName(name: Name?): String? {
        val type = object : TypeToken<Name>() {}.type
        return Gson().toJson(name, type)
    }
    @TypeConverter
    fun toName(nameString: String?): Name? {
        val type = object : TypeToken<Name>() {}.type
        return Gson().fromJson<Name>(nameString, type)
    }





}