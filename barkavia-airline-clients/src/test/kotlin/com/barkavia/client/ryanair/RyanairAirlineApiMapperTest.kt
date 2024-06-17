package com.barkavia.client.ryanair

import com.barkavia.client.common.AirportCode
import com.barkavia.client.common.SearchTripsInternalRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RyanairAirlineApiMapperTest {

    private val mapper = RyanairAirlineApiMapper()

    @Test
    fun `maps internal search request to ryanair api request`() {
        val request = SearchTripsInternalRequest(
            origin = AirportCode("WAW"),
            destination = AirportCode("BCN"),
            departureDate = LocalDate.of(2021, 10, 10),
            returnDate = LocalDate.of(2021, 10, 20),
            numberOfPassengers = 2
        )

        val ryanairRequest = mapper.toSearchTripsRequest(request)

        with(ryanairRequest) {
            assertThat(origin).isEqualTo("WAW")
            assertThat(destination).isEqualTo("BCN")
            assertThat(departureDate).isEqualTo("2021-10-10")
            assertThat(returnDate).isEqualTo("2021-10-20")
            assertThat(numberOfPassengers).isEqualTo(2)
        }
    }

    @Test
    fun `maps ryanair api response to internal response`() {
        val ryanairResponse = ryanairSearchTripsOkResponse

        val internalResponse = mapper.toTripsResponse(ryanairResponse)

        assertThat(internalResponse.trips).hasSize(2)
        assertThat(internalResponse).isEqualTo(ryanairInternalTripsResponse)
    }
}