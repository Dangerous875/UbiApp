package com.barzabaldevs.ubiapp.domain.usecases

import com.barzabaldevs.ubiapp.data.remote.model.NominatimResponse
import com.barzabaldevs.ubiapp.domain.Repository
import javax.inject.Inject

class GetCoordinatesUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(address: String): List<NominatimResponse>? {
        return repository.getCoordinates(address)
    }
}