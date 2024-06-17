package com.barkavia.api.search

import com.barkavia.api.search.FlightSegment.FlightSegmentId
import com.barkavia.client.common.TripsInternalResponse
import com.barkavia.pet.holder.PetAuthInformation
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.OffsetDateTime

data class TripsPublicResponse(
    val trips: List<Trip>,
    val dictionaries: Dictionary,
) {
    data class Dictionary(
        var segments: List<FlightSegment>,
        val petInformation: Map<AirlineCode, PetInformation?>,
    )
}

data class Trip(
    val originAirportCode: AirportCode,
    val destinationAirportCode: AirportCode,
    @JsonFormat(pattern = "HH:mm:ss")
    val totalDuration: java.time.Duration,
    val segments: List<FlightSegmentId>,
    val price: TripPrice,
    val advantage: TripAdvantage = TripAdvantage.NONE,
) {

    companion object {
        fun fromInternalTrip(internalTrip: TripsInternalResponse.Trip, advantage: TripAdvantage): Trip {
            return Trip(
                originAirportCode = AirportCode(internalTrip.originAirportCode.value),
                destinationAirportCode = AirportCode(internalTrip.destinationAirportCode.value),
                totalDuration = internalTrip.totalDuration,
                segments = internalTrip.segments.map { FlightSegmentId(it.value) },
                price = internalTrip.price.let { TripPrice(it.totalInCents, it.currency) },
                advantage = advantage,
            )
        }
    }
}

data class PetInformation(
    val allowed: Boolean,
    val chargePoints: List<String>? = null,
    val readMoreLink: String? = null,
    val weight: PetWeightInfo? = null,
    val scaleInfo: String? = null,
) {

    data class PetWeightInfo(
        val maxInKg: Int,
        val readable: String,
    )

    companion object {
        fun fromInternal(petAuthInformation: PetAuthInformation?): PetInformation {
            return PetInformation(
                allowed = petAuthInformation?.allowedInCabin ?: false,
                chargePoints = petAuthInformation?.chargePoints,
                readMoreLink = petAuthInformation?.readMoreLink.toString(),
                weight = petAuthInformation?.weight?.let { PetWeightInfo(it.kg, it.readable) },
                scaleInfo = petAuthInformation?.transportationBagScaleInfo,
            )
        }
    }
}

enum class TripAdvantage(val priority: Int) {
    BEST(150),
    FASTEST(100),
    CHEAPEST(50),
    NONE(0);
}

data class TripPrice(
    val totalInCents: Int,
    val currency: String,
)

data class FlightSegment(
    val id: FlightSegmentId,
    val flightNumber: String, // e.g. LO4719
    val departure: PointInTime,
    val arrival: PointInTime,
    val duration: java.time.Duration, // in seconds
    val airline: Airline,
    val aircraft: Aircraft? = null,
) {
    @JvmInline
    value class FlightSegmentId(private val value: String)

    data class PointInTime(
        val airportCode: AirportCode,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        val dateTime: OffsetDateTime, // 2024-06-16T15:30:00+02:00
        val terminal: String? = null,
    )

    data class Aircraft(
        val name: String, // e.g. Airbus A320
        val code: String, // e.g. 32Q
        val features: List<AircraftFeatures>,
    ) {
        data class AircraftFeatures(
            val title: String, // 1 x snack, 1 x drink
            val applicability: String, // included
        )
    }

    companion object {
        fun fromInternal(internalSegment: TripsInternalResponse.FlightSegment): FlightSegment {
            return FlightSegment(
                id = FlightSegmentId(internalSegment.id.value),
                flightNumber = internalSegment.flightNumber,
                departure = PointInTime(
                    airportCode = AirportCode(internalSegment.departure.airportCode.value),
                    dateTime = internalSegment.departure.dateTime,
                    terminal = internalSegment.departure.terminal,
                ),
                arrival = PointInTime(
                    airportCode = AirportCode(internalSegment.arrival.airportCode.value),
                    dateTime = internalSegment.arrival.dateTime,
                    terminal = internalSegment.arrival.terminal,
                ),
                duration = internalSegment.duration,
                airline = Airline(
                    name = internalSegment.airline.name,
                    code = AirlineCode(internalSegment.airline.code.value),
                ),
                aircraft = internalSegment.aircraft?.let { aircraft ->
                    Aircraft(
                        name = aircraft.name,
                        code = aircraft.code,
                        features = aircraft.features.map { feature ->
                            Aircraft.AircraftFeatures(
                                title = feature.title,
                                applicability = feature.applicability,
                            )
                        },
                    )
                },
            )
        }
    }
}

data class Airline(
    val name: String,
    val code: AirlineCode,
)

/**
 * IATA airport code, e.g. `WAW` for `Warsaw Chopin Airport`
 * @see <a href="https://en.wikipedia.org/wiki/List_of_airports_by_IATA_airport_code:_A">List of IATA airport codes</a>
 */
@JvmInline
value class AirportCode(val value: String) {
    init {
        require(value.length == 3) { "Airport code must be exactly 3 characters long" }
    }
}

/**
 * IATA airline code, e.g. `LO` for `LOT Polish Airlines`
 * @see <a href="https://en.wikipedia.org/wiki/List_of_airline_codes">List of IATA airline code</a>
 */
@JvmInline
value class AirlineCode(val code: String)
