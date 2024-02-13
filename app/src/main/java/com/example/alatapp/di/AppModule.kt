package com.example.moviesappcompose.di

import android.app.Application
import androidx.room.Room
import com.example.alatapp.welcomescreen.data.CountryApi
import com.example.alatapp.welcomescreen.data.local.CountryCodeAndFlagDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient =
        OkHttpClient().newBuilder().
        addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun providesMovieApi(): CountryApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CountryApi.BASE_URL)
            .client(client)
            .build()
            .create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(application: Application): CountryCodeAndFlagDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = CountryCodeAndFlagDatabase::class.java,
            name = "movie_db.db"
        ).fallbackToDestructiveMigration().build()
    }
}