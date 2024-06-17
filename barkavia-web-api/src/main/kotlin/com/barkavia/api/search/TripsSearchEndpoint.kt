package com.barkavia.api.search

import com.barkavia.api.search.dispatcher.TripsSearchDispatcher
import com.barkavia.client.common.SearchTripsInternalRequest
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import com.barkavia.client.common.AirportCode as InternalAirportCode

@RestController
@RequestMapping("/api/trips/search")
internal class TripsSearchEndpoint(
    private val tripsSearchOrchestrator: TripsSearchDispatcher,
) {

    @PostMapping
    fun search(@RequestBody request: SearchFlightsRequest): TripsPublicResponse = runBlocking {
        return@runBlocking tripsSearchOrchestrator.searchTrips(request)
    }
}

data class SearchFlightsRequest(
    val origin: AirportCode,
    val destination: AirportCode,
    val departureDate: String,
    val returnDate: String?,
    val numberOfPassengers: Int,
) {
    fun asInternalRequest() = SearchTripsInternalRequest(
        origin = InternalAirportCode(origin.value),
        destination = InternalAirportCode(destination.value),
        departureDate = LocalDate.parse(departureDate),
        returnDate = returnDate?.let { LocalDate.parse(it) },
        numberOfPassengers = numberOfPassengers,
    )
}
