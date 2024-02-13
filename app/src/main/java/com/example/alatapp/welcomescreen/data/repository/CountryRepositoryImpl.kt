package com.example.alatapp.welcomescreen.data.repository

import com.example.alatapp.welcomescreen.data.CountryApi
import com.example.alatapp.welcomescreen.data.local.CountryCodeAndFlagDatabase
import com.example.alatapp.welcomescreen.data.mapper.toCountryCodeAndFlagItem
import com.example.alatapp.welcomescreen.data.mapper.toCountryCodeWithFlagEntity
import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagItem
import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagResponse
import com.example.alatapp.welcomescreen.domain.CountryRepository
import com.example.moviesappcompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryApi: CountryApi,
    private val countryCodeAndFlagDatabase: CountryCodeAndFlagDatabase
) : CountryRepository {

    override suspend fun getCountryCodeWithFlag(
        forceFetchFromRemote: Boolean
    ): Flow<Resource<List<CountryCodeAndFlagItem>>> {
        return flow {
            emit(Resource.Loading(true))
            val localMovieList =
                countryCodeAndFlagDatabase.countryCodeAndFlagDao.getAllCountryCodeAndFlag()
            val shouldLoadMovieLocally = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if (shouldLoadMovieLocally) {
                emit(Resource.Success(data = localMovieList.map { entity ->
                    entity.toCountryCodeAndFlagItem()
                }))
                emit(Resource.Loading(false))
                return@flow
            }

            else {
                val countryCodeAndFlagListFromRemote = try {

                    emit(Resource.Loading(true))
                    emit(Resource.Success(countryApi.getCountryCodeAndFlagList()))
                    val countryCodeAndFlagEntities = countryApi.getCountryCodeAndFlagList().let {
                        it.map { countryCodeAndFlag ->
                            countryCodeAndFlag.toCountryCodeWithFlagEntity()
                        }
                    }
                    countryCodeAndFlagDatabase.countryCodeAndFlagDao.upsertCountryCodeAndFlagList(
                        countryCodeAndFlagEntities
                    )

                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = "Please Check your internet"))
                    e.response()?.errorBody()

                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = "Error Loading Movies"))

                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error(message = "Error Loading Movies"))

                }
//
//            val countryCodeAndFlagEntities = countryCodeAndFlagListFromRemote.let {
//                it.map { countryCodeAndFlag ->
//                    countryCodeAndFlag.toCountryCodeWithFlagEntity()
//                }
//            }

                return@flow
            }
        }
    }
}