package com.barkavia.client.lot

import com.barkavia.client.common.AirportCode
import com.barkavia.client.common.SearchTripsInternalRequest
import ryanairInternalTripsResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LotAirlineApiMapperTest {

    private val mapper = LotAirlineApiMapper()

    @Test
    fun `maps internal search request to lot api request`() {
        val request = SearchTripsInternalRequest(
            origin = AirportCode("WAW"),
            destination = AirportCode("BCN"),
            departureDate = LocalDate.of(2021, 10, 10),
            returnDate = LocalDate.of(2021, 10, 20),
            numberOfPassengers = 2
        )

        val lotRequest = mapper.toSearchTripsRequest(request)

        with(lotRequest) {
            assertThat(travelers).isEqualTo(listOf("ADT", "ADT"))
            assertThat(compartment).isEqualTo("ECONOMY")
            assertThat(itinerary).hasSize(2)
            assertThat(itinerary[0].originLocationCode).isEqualTo("WAW")
            assertThat(itinerary[0].destinationLocationCode).isEqualTo("BCN")
            assertThat(itinerary[0].departureDate).isEqualTo("2021-10-10")
            assertThat(itinerary[0].isRequestedBound).isTrue()
            assertThat(itinerary[1].originLocationCode).isEqualTo("BCN")
            assertThat(itinerary[1].destinationLocationCode).isEqualTo("WAW")
            assertThat(itinerary[1].departureDate).isEqualTo("2021-10-20")
            assertThat(itinerary[1].isRequestedBound).isFalse()
            assertThat(searchPreferences).isEmpty()
            assertThat(promotion).isNull()
        }
    }

    @Test
    fun `maps lot api response to internal response`() {
        val lotResponse = lotSearchTripsOkResponse

        val internalResponse = mapper.toTripsResponse(lotResponse)

        assertThat(internalResponse.trips).hasSize(1)
        assertThat(internalResponse).isEqualTo(lotInternalTripsResponse)
    }
}