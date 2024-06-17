package com.barkavia.pet.holder

import com.barkavia.pet.holder.AirlinePetInformationOrchestrator.getPetAuthInformation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class AirlinePetInformationOrchestratorTest {

    @Test
    fun `returns null for unknown airline`() {
        val airline = AirlineCode("XX")
        val petAuthInfo = getPetAuthInformation(airline)

        assertEquals(null, petAuthInfo)
    }

    @Test
    fun `returns pet auth information for LOT airline`() {
        val airline = AirlineCode("LO")
        val petAuthInfo = getPetAuthInformation(airline)

        assertNotNull(petAuthInfo)
        assertEquals(true, petAuthInfo!!.allowedInCabin)
    }

    @Test
    fun `returns pet auth information for Ryanair airline`() {
        val airline = AirlineCode("FR")
        val petAuthInfo = getPetAuthInformation(airline)

        assertEquals(PetAuthInformation.NOT_ALLOWED, petAuthInfo)
    }
}
