package com.barkavia.pet.holder

import java.net.URI

data class PetAuthInformation(
    val allowedInCabin: Boolean,
    val chargePoints: List<String>? = null,
    val readMoreLink: URI? = null,
    val weight: PetWeightAllowed? = null,
    val transportationBagScaleInfo: String? = null,
) {

    data class PetWeightAllowed(
        val kg: Int,
        val readable: String,
        val withTransportationBag: Boolean = true,
    )

    companion object {
        val NOT_ALLOWED = PetAuthInformation(allowedInCabin = false)
    }
}

@JvmInline
value class AirlineCode(private val code: String) {
    init {
        require(code.length == 2) { "Airline code must be exactly 2 characters long" }
    }
}
