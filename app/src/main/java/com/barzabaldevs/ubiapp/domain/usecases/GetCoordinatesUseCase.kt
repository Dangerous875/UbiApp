package com.barzabaldevs.ubiapp.domain.usecases

import android.content.Context
import com.barzabaldevs.ubiapp.R
import com.barzabaldevs.ubiapp.data.remote.model.GeocodingResponse
import com.barzabaldevs.ubiapp.domain.Repository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetCoordinatesUseCase @Inject constructor(
    private val repository: Repository,
    @ApplicationContext private val context: Context
) {

    suspend operator fun invoke(address: String): GeocodingResponse? {
        val apiKey = context.getString(R.string.google_maps_api_key)
        return repository.getCoordinates(address, apiKey)
    }
}