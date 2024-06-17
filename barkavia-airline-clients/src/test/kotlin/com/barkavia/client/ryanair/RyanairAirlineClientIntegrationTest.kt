package com.barkavia.client.ryanair

import com.barkavia.client.AirlineClientIntegrationTest
import com.barkavia.client.common.asIso8601
import com.github.tomakehurst.wiremock.client.WireMock.*
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate.now

internal class RyanairAirlineClientIntegrationTest : AirlineClientIntegrationTest() {

    @Autowired
    lateinit var ryanairAirlineClient: RyanairAirlineClient

    @Test
    fun `searches ryanair trips successfully`(): Unit = runBlocking {
        val request = RyanairSearchTripsRequest(
            numberOfPassengers = 1,
            departureDate = now().asIso8601(),
            returnDate = now().plusDays(1).asIso8601(),
            origin = "WMI",
            destination = "LIS"
        )

        airlineClientServer.stubFor(
            get(urlPathMatching("/api/booking/v4/en-gb/availability?.*"))
                .willReturn(aResponse().withBody(ryanairSearchTripsOkResponseRaw))
        )
        val response = ryanairAirlineClient.searchTrips(request)

        assertThat(response).isEqualTo(ryanairSearchTripsOkResponse)
    }

    @Test
    fun `searches ryanair trips responds with bad request`(): Unit = runBlocking {
        val request = RyanairSearchTripsRequest(
            numberOfPassengers = 1,
            departureDate = now().asIso8601(),
            returnDate = now().plusDays(1).asIso8601(),
            origin = "WM",
            destination = "LIS"
        )

        airlineClientServer.stubFor(
            get(urlPathMatching("/api/booking/v4/en-gb/availability?.*"))
                .willReturn(aResponse().withBody(ryanairSearchTripsBadRequestResponseRaw).withStatus(400))
        )
        val response = ryanairAirlineClient.searchTrips(request)

        assertThat(response).isNull()
    }
}
