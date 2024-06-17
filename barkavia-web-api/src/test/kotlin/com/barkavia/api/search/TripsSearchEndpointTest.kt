package com.barkavia.api.search

import com.barkavia.api.EndpointTest
import com.barkavia.client.lot.LotAirlineClient
import com.barkavia.client.lot.lotSearchTripsOkResponse
import kotlinx.coroutines.runBlocking
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class TripsSearchEndpointTest : EndpointTest() {

    @Autowired
    private lateinit var lotAirlineClient: LotAirlineClient

    @Test
    fun `search for trips returns response with trips and dictionary`(): Unit = runBlocking {
        whenever(lotAirlineClient.searchTrips(any())).thenReturn(lotSearchTripsOkResponse)

        mockMvc
            .perform(
                post("/api/trips/search")
                    .content(simpleSearchTripsRequest)
                    .contentType(APPLICATION_JSON)
            )
            .andExpect(status().isOk)
            .andExpect(content().json(expectedSearch200Response))
    }

    @Test
    fun `search for trips returns empty response if not found`(): Unit = runBlocking {
        whenever(lotAirlineClient.searchTrips(any())).thenReturn(null)

        mockMvc
            .perform(
                post("/api/trips/search")
                    .content(simpleSearchTripsRequest)
                    .contentType(APPLICATION_JSON)
            )
            .andExpect(status().isOk)
            .andExpect(content().json(expectedSearch200EmptyResultsResponse))
    }

    @Test
    fun `search for trips returns empty response if failed`(): Unit = runBlocking {
        whenever(lotAirlineClient.searchTrips(any())).thenThrow(IllegalArgumentException("Invalid request"))

        mockMvc
            .perform(
                post("/api/trips/search")
                    .content(simpleSearchTripsRequest)
                    .contentType(APPLICATION_JSON)
            )
            .andExpect(status().isOk)
            .andExpect(content().json(expectedSearch200EmptyResultsResponse))
    }

    @Test
    fun `search for trips with bad request returns bad request`() {
        mockMvc
            .perform(
                post("/api/trips/search")
                    .content(badSearchTripsRequest)
                    .contentType(APPLICATION_JSON)
            )
            .andExpect(status().isBadRequest)
    }

    private companion object {

        @Language("JSON")
        val simpleSearchTripsRequest = """
        {
            "origin": "WAW",
            "destination": "BCN",
            "departureDate": "2024-01-01",
            "returnDate": "2024-01-10",
            "numberOfPassengers": 1
        }
        """.trimIndent()

        @Language("JSON")
        val badSearchTripsRequest = """
        {
            "origin": "WA",
            "destination": "BCN",
            "departureDate": "2024-01-01",
            "returnDate": "2024-01-10",
            "numberOfPassengers": 1
        }
        """.trimIndent()

        @Language("JSON")
        val expectedSearch200Response = """
            {"trips":[{"originAirportCode":"WAW","destinationAirportCode":"LHR","totalDuration":10500.000000000,"segments":["SEG-LO281-WAWLHR-2024-06-21-0725"],"price":{"totalInCents":54511,"currency":"PLN"},"advantage":"CHEAPEST"}],"dictionaries":{"segments":[{"id":"SEG-LO281-WAWLHR-2024-06-21-0725","flightNumber":"LO281","departure":{"airportCode":"WAW","dateTime":"2024-06-21T07:25:00+02:00","terminal":null},"arrival":{"airportCode":"LHR","dateTime":"2024-06-21T09:20:00+01:00","terminal":"2"},"duration":10500.000000000,"airline":{"name":"LOT POLISH AIRLINES","code":"LO"},"aircraft":{"name":"BOEING 737 MAX 8","code":"7M8","features":[{"title":"E-press","applicability":"included"},{"title":"1 x snack, 1 x drink","applicability":"included"},{"title":"Onboard entertainment","applicability":"included"}]}}],"petInformation":{"LO":{"allowed":true,"chargePoints":["190 PLN on domestic flights within Poland (+ VAT 8%)","280 PLN/65 EUR/70 USD/90 CAD on short- and mid haul flights within Europe, the Middle East (i.g UAE, Saudi Arabia) and Central Asia (Uzbekistan, Kazakhstan)","465 PLN/100 EUR/120 USD/150 CAD/15 000 JPY/150 000 KRW/8500 INR/40 000 HUF on long-haul flights to/from North America and East Asia."],"readMoreLink":"https://www.lot.com/us/en/journey/special-services/traveling-with-pets/pet-in-cabin","weight":{"maxInKg":8,"readable":"Pet should be up to 8 kg. gross, including the transport bag"},"scaleInfo":"Accepted length, width and height of the transport bag: 45/30/20 cm"}}}}
        """.trimIndent()

        @Language("JSON")
        val expectedSearch200EmptyResultsResponse =
            "{\"trips\":[],\"dictionaries\":{\"segments\":[],\"petInformation\":{}}}"
    }
}
