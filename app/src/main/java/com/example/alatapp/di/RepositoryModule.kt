package com.example.moviesappcompose.di

import com.example.alatapp.welcomescreen.data.repository.CountryRepositoryImpl
import com.example.alatapp.welcomescreen.domain.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountryCodeAndFlagRepository(
        countryRepositoryImpl: CountryRepositoryImpl
    ) : CountryRepository
}