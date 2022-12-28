package com.natcho.weatherapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natcho.weatherapp.common.result.Result
import com.natcho.weatherapp.domain.model.WeatherInfo
import com.natcho.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val _weatherUiState = MutableLiveData<WeatherUiState>()
    val weatherUiState: LiveData<WeatherUiState> = _weatherUiState

    fun loadCurrentWeatherInfo() {
        viewModelScope.launch {
            when (val response = repository.getCurrentWeatherByGeoCoordinates(13.736717, 100.523186)) {
                is Result.Loading -> {
                    _weatherUiState.value = WeatherUiState.Loading
                }
                is Result.Success -> {
                    _weatherUiState.value = WeatherUiState.Success(response.data)
                }
                is Result.Error -> {
                    _weatherUiState.value = WeatherUiState.Error
                }
            }
        }
    }
}

sealed interface WeatherUiState {
    data class Success(val weatherInfo: WeatherInfo) : WeatherUiState
    object Error : WeatherUiState
    object Loading : WeatherUiState
}