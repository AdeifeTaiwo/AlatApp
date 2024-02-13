package com.example.alatapp.welcomescreen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alatapp.welcomescreen.domain.CountryRepository
import com.example.moviesappcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {

    private var _countryListState = MutableStateFlow(WelcomeScreenState())
    val countryListState = _countryListState.asStateFlow()

    init {
        initCountryCodeWithFlag()
    }

    private fun initCountryCodeWithFlag() {
        viewModelScope.launch {
            countryRepository.getCountryCodeWithFlag(forceFetchFromRemote = false)
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            Log.d("Alat", "Success")
                            result.data.let { countryList ->
                                _countryListState.update {
                                    it.copy(
                                        isLoading = false,
                                        countryCodeWithFlagList = countryList?: emptyList(),

                                    )
                                }
                            }

                        }

                        is Resource.Error -> {
                            Log.d("Alat", result.message ?: "error")
                            _countryListState.update {
                                it.copy(
                                    isLoading = false,
                                    hasError = true,
                                    errorMessage = it.errorMessage
                                )
                            }
                        }

                        else -> {

                        }
                    }
                }
        }
    }

}