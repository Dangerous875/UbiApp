package com.barzabaldevs.ubiapp.data.remote

import com.barzabaldevs.ubiapp.data.remote.model.GeocodingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {
    @GET("geocode/json")
    suspend fun getCoordinates(
        @Query("address") address: String,
        @Query("key") apiKey: String
    ): Response<GeocodingResponse>
}