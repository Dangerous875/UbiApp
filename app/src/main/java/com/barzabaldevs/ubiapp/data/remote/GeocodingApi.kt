package com.barzabaldevs.ubiapp.data.remote

import com.barzabaldevs.ubiapp.data.remote.model.NominatimResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {
    @GET("search")
    suspend fun getCoordinates(
        @Query("q") address: String,
        @Query("format") format: String = "json"
    ): Response<List<NominatimResponse>>
}