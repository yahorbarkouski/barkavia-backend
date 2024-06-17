package com.barkavia.pet.holder

import com.barkavia.pet.holder.predefined.LotPetAuthHolder
import com.barkavia.pet.holder.predefined.RyanairPetAuthHolder

object AirlinePetInformationOrchestrator {

    private val predefinedHolders = setOf(
        LotPetAuthHolder,
        RyanairPetAuthHolder,
    )

    fun getPetAuthInformation(airline: AirlineCode): PetAuthInformation? {
        return predefinedHolders.firstOrNull { it.getAirlineCode() == airline }?.getPetAuthInfo()
    }
}
