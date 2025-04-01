package com.barzabaldevs.ubiapp.domain

import com.barzabaldevs.ubiapp.data.remote.model.NominatimResponse

interface Repository {
    suspend fun getCoordinates(address: String): List<NominatimResponse>?
}