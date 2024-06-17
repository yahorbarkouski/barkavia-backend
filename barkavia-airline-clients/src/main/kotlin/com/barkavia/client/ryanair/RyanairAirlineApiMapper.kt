package com.barkavia.client.ryanair

import com.barkavia.client.common.*
import com.barkavia.client.common.TripsInternalResponse.*
import com.barkavia.client.common.TripsInternalResponse.FlightSegment.*
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toJavaDuration

@Component
class RyanairAirlineApiMapper : AirlineApiMapper<RyanairSearchTripsRequest, RyanairTripsResponse> {

    override fun toSearchTripsRequest(request: SearchTripsInternalRequest): RyanairSearchTripsRequest {
        return RyanairSearchTripsRequest(
            origin = request.origin.value,
            destination = request.destination.value,
            departureDate = request.departureDate.asIso8601(),
            returnDate = request.returnDate?.asIso8601(),
            numberOfPassengers = request.numberOfPassengers
        )
    }

    override fun toTripsResponse(response: RyanairTripsResponse): TripsInternalResponse {
        return TripsInternalResponse(
            trips = response.trips.flatMap { trip ->
                trip.dates.flatMap { dates ->
                    dates.flights
                        .filter { it.faresLeft > 0 }
                        .map { flight ->
                            Trip(
                                originAirportCode = AirportCode(flight.segments.first().origin),
                                destinationAirportCode = AirportCode(flight.segments.last().destination),
                                totalDuration = flight.segments.map { it.duration.asDuration() }
                                    .reduce { acc, duration -> acc + duration }.toJavaDuration(),
                                segments = flight.segments.map { segment ->
                                    FlightSegmentId(segment.origin + "-" + segment.destination + "-" + segment.time.first())
                                },
                                price = Trip.TripPrice(
                                    ((flight.regularFare?.fares?.first()?.amount ?: 0.0) * 100).toInt(),
                                    response.currency
                                )
                            )
                        }
                }
            },
            dictionaries = Dictionary(
                segments = response.trips.flatMap { trip -> trip.dates.flatMap { date -> date.flights.flatMap { it.segments } } }
                    .map { segment ->
                        FlightSegment(
                            id = FlightSegmentId(segment.origin + "-" + segment.destination + "-" + segment.time.first()),
                            flightNumber = segment.flightNumber,
                            departure = PointInTime(
                                airportCode = AirportCode(segment.origin),
                                dateTime = toOffsetDateTime(segment.time[0], segment.timeUTC[0])
                            ),
                            arrival = PointInTime(
                                airportCode = AirportCode(segment.destination),
                                dateTime = toOffsetDateTime(segment.time[1], segment.timeUTC[1])
                            ),
                            duration = segment.duration.asDuration().toJavaDuration(),
                            airline = Airline(
                                "Ryanair",
                                AirlineCode("FR")
                            ),
                        )
                    },
            )
        )
    }

    private fun toOffsetDateTime(time: String, utcTime: String): OffsetDateTime {
        val localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"))
        val utcZonedDateTime = ZonedDateTime.parse(utcTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"))

        val duration = java.time.Duration.between(utcZonedDateTime, localDateTime.atZone(ZoneOffset.UTC))

        val offsetSeconds = duration.seconds.toInt()
        val offset = ZoneOffset.ofTotalSeconds(offsetSeconds)

        return localDateTime.atOffset(offset)
    }

    // "07:30" -> Duration object
    private fun String.asDuration(): Duration {
        val parts = this.split(":")
        require(parts.size == 2) { "Duration must be in the format HH:MM" }

        val hours = parts[0].toLong()
        val minutes = parts[1].toLong()

        return hours.hours + minutes.minutes
    }
}
