package com.barkavia.pet.holder.predefined

import com.barkavia.pet.holder.AirlineCode
import com.barkavia.pet.holder.PetAuthInformation

object RyanairPetAuthHolder : AirlinePetAuthHolder {

    override fun getAirlineCode(): AirlineCode = AirlineCode("FR")

    override fun getPetAuthInfo() = PetAuthInformation.NOT_ALLOWED
}
