package com.barkavia.client.common

import java.time.Duration
import java.time.OffsetDateTime

data class TripsInternalResponse(
    val trips: List<Trip>,
    val dictionaries: Dictionary,
) {
    data class Dictionary(
        var segments: List<FlightSegment>
    )

    data class Trip(
        val originAirportCode: AirportCode,
        val destinationAirportCode: AirportCode,
        val totalDuration: Duration,
        val segments: List<FlightSegment.FlightSegmentId>,
        val price: TripPrice,
    ) {

        data class TripPrice(
            val totalInCents: Int,
            val currency: String,
        )
    }

    data class FlightSegment(
        val id: FlightSegmentId,
        val flightNumber: String,
        val departure: PointInTime,
        val arrival: PointInTime,
        val duration: Duration,
        val airline: Airline,
        val aircraft: Aircraft? = null,
    ) {
        @JvmInline
        value class FlightSegmentId(val value: String)

        data class PointInTime(
            val airportCode: AirportCode,
            val dateTime: OffsetDateTime,
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

        data class Airline(
            val name: String,
            val code: AirlineCode,
        )

        @JvmInline
        value class AirlineCode(val value: String) {
            init {
                require(value.length == 2) { "Airline code must be 2 characters representing IATA code" }
            }
        }
    }
}

@JvmInline
value class AirportCode(val value: String) {
    init {
        require(value.length == 3) { "Airport code must be 3 characters representing IATA code" }
    }
}
