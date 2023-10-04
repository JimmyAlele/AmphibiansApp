package com.alele.amphibians.data

import com.alele.amphibians.model.Amphibians
import com.alele.amphibians.network.AmphibiansApiService

/**
 * A repository that fetches amphibians list from amphibiansApi
 */

interface AmphibiansRepository {
    /**
     * fetches list of amphibians from amphibiansApi
     */
    suspend fun getAmphibiansData(): List<Amphibians>
}

/**
 * Network implementation of Repository that fetch amphibians list from amphibiansApi.
 */

class NetworkAmphibiansRepository (
    private val amphibiansApiService: AmphibiansApiService): AmphibiansRepository {
    /**
     * fetches list of amphibians from amphibiansApiService
     */
    override suspend fun getAmphibiansData(): List<Amphibians> {
        return amphibiansApiService.getAmphibiansData()
    }
}