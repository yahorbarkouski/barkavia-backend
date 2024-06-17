package com.barkavia.client.lot

import com.barkavia.client.common.*
import com.barkavia.client.common.TripsInternalResponse.FlightSegment
import com.barkavia.client.common.TripsInternalResponse.FlightSegment.*
import com.barkavia.client.common.TripsInternalResponse.FlightSegment.Aircraft.AircraftFeatures
import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

@Component
class LotAirlineApiMapper : AirlineApiMapper<LotSearchTripsRequest, LotTripsResponse> {

    override fun toSearchTripsRequest(request: SearchTripsInternalRequest): LotSearchTripsRequest {
        val travelersList = mutableListOf<String>()
        for (i in 1..request.numberOfPassengers) {
            travelersList.add("ADT")
        }

        return LotSearchTripsRequest(
            travelers = travelersList,
            compartment = "ECONOMY",
            itinerary = listOf(
                LotSearchTripsRequest.Itinerary(
                    originLocationCode = request.origin.value,
                    destinationLocationCode = request.destination.value,
                    departureDate = request.departureDate.asIso8601(),
                    isRequestedBound = true
                ),
                LotSearchTripsRequest.Itinerary(
                    originLocationCode = request.destination.value,
                    destinationLocationCode = request.origin.value,
                    departureDate = request.returnDate?.asIso8601() ?: "",
                    isRequestedBound = false
                )
            )
        )
    }

    override fun toTripsResponse(response: LotTripsResponse): TripsInternalResponse {
        return TripsInternalResponse(
            trips = response.data.airBoundFlights.map { lotFlightResponse ->
                TripsInternalResponse.Trip(
                    originAirportCode = AirportCode(lotFlightResponse.flight.originLocationCode),
                    destinationAirportCode = AirportCode(lotFlightResponse.flight.destinationLocationCode),
                    totalDuration = lotFlightResponse.flight.duration.seconds.toJavaDuration(),
                    segments = lotFlightResponse.flight.segments.map { s ->
                        FlightSegmentId(
                            s.segmentId
                        )
                    },
                    price = lotFlightResponse.airBoundOffers.first().prices.totalPrices.first().let { price ->
                        TripsInternalResponse.Trip.TripPrice(
                            totalInCents = price.total,
                            currency = price.currencyCode
                        )
                    }
                )
            },
            dictionaries = TripsInternalResponse.Dictionary(
                segments = response.dictionaries.segment.map { (lotSegmentKey, lotSegment) ->
                    FlightSegment(
                        id = FlightSegmentId(lotSegmentKey),
                        flightNumber = lotSegment.marketingAirlineCode + lotSegment.marketingFlightNumber,
                        departure = PointInTime(
                            airportCode = AirportCode(lotSegment.departure.locationCode),
                            dateTime = OffsetDateTime.parse(
                                lotSegment.departure.dateTime,
                                DateTimeFormatter.ISO_OFFSET_DATE_TIME
                            ),
                            terminal = lotSegment.departure.terminal
                        ),
                        arrival = PointInTime(
                            airportCode = AirportCode(lotSegment.arrival.locationCode),
                            dateTime = OffsetDateTime.parse(
                                lotSegment.arrival.dateTime,
                                DateTimeFormatter.ISO_OFFSET_DATE_TIME
                            ),
                            terminal = lotSegment.arrival.terminal
                        ),
                        duration = lotSegment.duration.seconds.toJavaDuration(),
                        aircraft = Aircraft(
                            name = response.dictionaries.aircraft[lotSegment.aircraftCode] ?: "Unknown",
                            code = lotSegment.aircraftCode,
                            features = lotSegment.features.map { feature ->
                                AircraftFeatures(
                                    title = feature.title,
                                    applicability = feature.applicability
                                )
                            }
                        ),
                        airline = Airline(
                            code = AirlineCode(lotSegment.marketingAirlineCode),
                            name = response.dictionaries.airline[lotSegment.marketingAirlineCode] ?: "Unknown"
                        )
                    )
                }
            )
        )
    }
}