package com.barzabaldevs.ubiapp.data.remote.service

import android.util.Log
import com.barzabaldevs.ubiapp.data.remote.GeocodingApi
import com.barzabaldevs.ubiapp.data.remote.model.NominatimResponse
import javax.inject.Inject

class ApiServiceGeocoding @Inject constructor(private val apiClient: GeocodingApi) {

    suspend fun getCoordinates(address: String): List<NominatimResponse>? {
        return try {
            val response = apiClient.getCoordinates(address)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e("ApiServiceGeocoding", "Error en la solicitud de geocoding", e)
            null
        }
    }
}