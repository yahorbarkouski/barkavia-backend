package com.barkavia.pet.holder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AirlineCodeConventionTest {

    @Test
    fun `airline code complies with IATA convention`() {
        assertDoesNotThrow { AirlineCode("AA") }

        assertThrows(IllegalArgumentException::class.java) { AirlineCode("A") }
            .also { assertEquals("Airline code must be exactly 2 characters long", it.message) }
    }
}
