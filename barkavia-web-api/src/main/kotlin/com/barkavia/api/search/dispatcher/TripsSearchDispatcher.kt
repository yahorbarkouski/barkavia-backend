package com.barkavia.api.search.dispatcher

import com.barkavia.api.search.*
import com.barkavia.api.search.TripsPublicResponse.Dictionary
import com.barkavia.api.search.dispatcher.service.TripsSearchService
import com.barkavia.client.common.TripsInternalResponse
import com.barkavia.pet.holder.AirlinePetInformationOrchestrator.getPetAuthInformation
import kotlinx.coroutines.*
import org.springframework.stereotype.Component
import com.barkavia.pet.holder.AirlineCode as PetAirlineCode

@Component
internal class TripsSearchDispatcher(
    private val tripsSearchService: List<TripsSearchService<*, *>>,
) {

    suspend fun searchTrips(request: SearchFlightsRequest): TripsPublicResponse = coroutineScope {
        val responses = tripsSearchService.map { service ->
            async {
                withContext(Dispatchers.IO) {
                    service.searchTrips(request.asInternalRequest())
                }
            }
        }.awaitAll().filterNotNull()

        return@coroutineScope responses.toPublicResponse()
    }

    private fun List<TripsInternalResponse>.toPublicResponse(): TripsPublicResponse {
        val involvedAirlines = this
            .flatMap { it.dictionaries.segments }
            .map { AirlineCode(it.airline.code.value) }
            .distinct()

        val petAuthInfoMap = involvedAirlines
            .associateWith { PetInformation.fromInternal(getPetAuthInformation(PetAirlineCode(it.code))) }

        return TripsPublicResponse(
            trips = this.asPublicResultsAwareTrips(),
            dictionaries = Dictionary(
                segments = this.flatMap { it.dictionaries.segments }.distinct().map { FlightSegment.fromInternal(it) },
                petInformation = petAuthInfoMap,
            )
        )
    }

    private fun List<TripsInternalResponse>.asPublicResultsAwareTrips(): List<Trip> {
        val allTrips = this.flatMap { it.trips }
        val cheapest = allTrips.minByOrNull { it.price.totalInCents }
        val fastest = allTrips.minByOrNull { it.totalDuration.toSeconds() }

        return allTrips.map {
            Trip.fromInternalTrip(
                it,
                advantage = when (it) {
                    cheapest -> TripAdvantage.CHEAPEST
                    fastest -> TripAdvantage.FASTEST
                    else -> TripAdvantage.NONE
                }
            )
        }.sortedByDescending { it.advantage.priority }
    }
}
