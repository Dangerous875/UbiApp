package com.barzabaldevs.ubiapp.domain

import com.barzabaldevs.ubiapp.data.remote.model.GeocodingResponse

interface Repository {
    suspend fun getCoordinates(address: String, apiKey: String): GeocodingResponse?
}