package com.barzabaldevs.ubiapp.ui.screens.homeScreen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barzabaldevs.ubiapp.domain.usecases.GetCoordinatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor
    (private val getCoordinatesUseCase: GetCoordinatesUseCase) : ViewModel() {
    private val _coordinates = MutableStateFlow<Pair<Double, Double>?>(null)
    val coordinates = _coordinates.asStateFlow()

    fun fetchCoordinates(address: String) {
        viewModelScope.launch {
            Log.i("KlyxDevs", "Adress : $address")
            try {
                val response = getCoordinatesUseCase(address)?.firstOrNull()
                Log.i("KlyxDevs", "cord1 : $response")
                if (response != null) {
                    _coordinates.value = response.lat.toDouble() to response.lon.toDouble()
                    Log.i("KlyxDevs", "cord1 : $_coordinates.value")
                }
            } catch (e: Exception) {
                Log.e("KlyxDevs", "Error al obtener coordenadas", e)
            }
        }
    }

}