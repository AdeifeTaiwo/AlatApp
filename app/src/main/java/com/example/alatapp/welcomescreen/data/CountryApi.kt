package com.example.alatapp.welcomescreen.data

import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryApi {

    @GET("all")
    suspend fun getCountryCodeAndFlagList(
    ): CountryCodeAndFlagResponse

    companion object {
        const val BASE_URL = "https://restcountries.com/v3.1/"
        const val IMAGE_BASE_URL = "http://image.tmdb/t/p/3/w500/"
        const val API_KEY = "f767e0d619672aa5579798ada55dca3f"
    }

}