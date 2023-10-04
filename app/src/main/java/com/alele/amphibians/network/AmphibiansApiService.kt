package com.alele.amphibians.network

import com.alele.amphibians.model.Amphibians
import retrofit2.http.GET

/**
 * A public interface that exposes the [getAmphibiansData] method
 */

interface AmphibiansApiService {
    /**
     * Returns a list of Amphibians and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "amphibians" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("amphibians")
    suspend fun getAmphibiansData(): List<Amphibians>
}