package com.barkavia.client.lot

import com.barkavia.client.AirlineClientIntegrationTest
import com.github.tomakehurst.wiremock.client.WireMock.*
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class LotAirlineClientIntegrationTest : AirlineClientIntegrationTest() {

    @Autowired
    lateinit var lotAirlineClient: LotAirlineClient

    @Test
    fun `searches ryanair trips successfully`(): Unit = runBlocking {
        val request = LotSearchTripsRequest(
            compartment = "ADT",
            itinerary = listOf(
                LotSearchTripsRequest.Itinerary(
                    originLocationCode = "WAW",
                    destinationLocationCode = "LHR",
                    departureDate = "2024-10-10",
                    isRequestedBound = true
                )
            )
        )

        airlineClientServer.stubFor(
            post(urlPathMatching("/api/v1/ibe/search/air-bounds"))
                .willReturn(aResponse().withBody(lotSearchTripsOkResponseRaw))
        )
        val response = lotAirlineClient.searchTrips(request)

        assertThat(response).isEqualTo(lotSearchTripsOkResponse)
    }

    @Test
    fun `searches ryanair trips responds with bad request`(): Unit = runBlocking {
        val request = LotSearchTripsRequest(
            compartment = "ADT",
            itinerary = listOf(
                LotSearchTripsRequest.Itinerary(
                    originLocationCode = "WAW",
                    destinationLocationCode = "BC",
                    departureDate = "2021-10-10",
                    isRequestedBound = true
                )
            )
        )

        airlineClientServer.stubFor(
            post(urlPathMatching("/api/v1/ibe/search/air-bounds"))
                .willReturn(aResponse().withBody(lotSearchTripsBadRequestResponseRaw).withStatus(400))
        )
        val response = lotAirlineClient.searchTrips(request)

        assertThat(response).isNull()
    }
}
