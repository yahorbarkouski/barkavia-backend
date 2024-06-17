package com.barkavia.pet.holder.predefined

import com.barkavia.pet.holder.AirlineCode
import com.barkavia.pet.holder.PetAuthInformation
import com.barkavia.pet.holder.PetAuthInformation.PetWeightAllowed
import java.net.URI

object LotPetAuthHolder : AirlinePetAuthHolder {

    override fun getAirlineCode(): AirlineCode = AirlineCode("LO")

    override fun getPetAuthInfo(): PetAuthInformation {
        return PetAuthInformation(
            allowedInCabin = true,
            chargePoints = listOf(
                "190 PLN on domestic flights within Poland (+ VAT 8%)",
                "280 PLN/65 EUR/70 USD/90 CAD on short- and mid haul flights within Europe, the Middle East (i.g UAE, Saudi Arabia) and Central Asia (Uzbekistan, Kazakhstan)",
                "465 PLN/100 EUR/120 USD/150 CAD/15 000 JPY/150 000 KRW/8500 INR/40 000 HUF on long-haul flights to/from North America and East Asia."
            ),
            readMoreLink = URI.create("https://www.lot.com/us/en/journey/special-services/traveling-with-pets/pet-in-cabin"),
            weight = PetWeightAllowed(
                kg = 8,
                readable = "Pet should be up to 8 kg. gross, including the transport bag"
            ),
            transportationBagScaleInfo = "Accepted length, width and height of the transport bag: 45/30/20 cm"
        )
    }
}

