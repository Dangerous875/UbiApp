package com.barzabaldevs.ubiapp.data

import com.barzabaldevs.ubiapp.data.remote.model.GeocodingResponse
import com.barzabaldevs.ubiapp.data.remote.service.ApiServiceGeocoding
import com.barzabaldevs.ubiapp.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiServiceGeocoding: ApiServiceGeocoding) :
    Repository {
    override suspend fun getCoordinates(address: String, apiKey: String): GeocodingResponse? {
        return apiServiceGeocoding.getCoordinates(address, apiKey)
    }
}