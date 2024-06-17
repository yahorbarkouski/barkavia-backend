package com.barkavia.client.common

import com.barkavia.client.common.TripsInternalResponse.FlightSegment.AirlineCode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TripsInternalResponseComplianceTest {

    @Test
    fun `airline code complies with IATA convention`() {
        assertDoesNotThrow { AirlineCode("LO") }

        assertThrows(IllegalArgumentException::class.java) { AirlineCode("X") }
            .also { assertEquals("Airline code must be 2 characters representing IATA code", it.message) }
    }

    @Test
    fun `airport code complies with IATA convention`() {
        assertDoesNotThrow { AirportCode("WAW") }

        assertThrows(IllegalArgumentException::class.java) { AirportCode("WA") }
            .also { assertEquals("Airport code must be 3 characters representing IATA code", it.message) }
    }
}