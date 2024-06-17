package com.barkavia.api.search.dispatcher.service

import com.barkavia.client.common.AirlineApiMapper
import com.barkavia.client.common.AirlineClient
import com.barkavia.client.common.SearchTripsInternalRequest
import com.barkavia.client.common.TripsInternalResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal abstract class TripsSearchService<RequestType, ResponseType> {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    abstract fun getMapper(): AirlineApiMapper<RequestType, ResponseType>

    abstract fun getClient(): AirlineClient<RequestType, ResponseType>

    suspend fun searchTrips(request: SearchTripsInternalRequest): TripsInternalResponse? {
        val airlineMapper = getMapper()
        val airlineSpecificRequest = airlineMapper.toSearchTripsRequest(request)

        val airlineSpecificResponse = try {
            getClient().searchTrips(airlineSpecificRequest)
        } catch (e: Exception) {
            log.warn("Error while searching trips: ", e)
            null
        }

        return airlineSpecificResponse?.let { airlineMapper.toTripsResponse(it) }
    }
}
