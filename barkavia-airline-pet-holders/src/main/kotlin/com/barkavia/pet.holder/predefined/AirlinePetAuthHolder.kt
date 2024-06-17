package com.barkavia.pet.holder.predefined

import com.barkavia.pet.holder.AirlineCode
import com.barkavia.pet.holder.PetAuthInformation

interface AirlinePetAuthHolder {

    fun getAirlineCode(): AirlineCode

    fun getPetAuthInfo(): PetAuthInformation
}
