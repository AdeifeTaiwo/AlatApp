package com.example.alatapp.welcomescreen.domain

import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagItem
import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagResponse
import com.example.moviesappcompose.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    suspend fun getCountryCodeWithFlag(
        forceFetchFromRemote: Boolean
    ): Flow<Resource<List<CountryCodeAndFlagItem>>>


}