package com.barkavia.client.ryanair

import com.barkavia.client.common.AirportCode
import com.barkavia.client.common.TripsInternalResponse
import java.time.OffsetDateTime
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toJavaDuration

val ryanairSearchTripsOkResponse = RyanairTripsResponse(
    currency = "PLN",
    currPrecision = 2,
    routeGroup = "LEISURE",
    tripType = "SUN_BREAK",
    upgradeType = "PLUS",
    trips = listOf(
        RyanairTripsResponse.Trip(
            origin = "WMI",
            originName = "Warsaw (Modlin)",
            destination = "LIS",
            destinationName = "Lisbon ",
            routeGroup = "LEISURE",
            tripType = "SUN_BREAK",
            upgradeType = "PLUS",
            dates = listOf(
                RyanairTripsResponse.Trip.Date(
                    dateOut = "2024-07-01T00:00:00.000",
                    flights = listOf(
                        RyanairTripsResponse.Trip.Date.Flight(
                            faresLeft = 5,
                            flightKey = "FR~2263~ ~~WMI~07/01/2024 05:45~LIS~07/01/2024 09:00~~",
                            infantsLeft = 17,
                            regularFare = RyanairTripsResponse.Trip.Date.Flight.RegularFare(
                                fareKey = "",
                                fareClass = "V",
                                fares = listOf(
                                    RyanairTripsResponse.Trip.Date.Flight.RegularFare.Fare(
                                        type = "ADT",
                                        amount = 614.0,
                                        count = 1,
                                        hasDiscount = false,
                                        publishedFare = 614.0,
                                        discountInPercent = 0,
                                        hasPromoDiscount = false,
                                        discountAmount = 0,
                                        hasBogof = false
                                    )
                                )
                            ),
                            operatedBy = "Buzz",
                            segments = listOf(
                                RyanairTripsResponse.Trip.Date.Flight.Segment(
                                    segmentNr = 0,
                                    origin = "WMI",
                                    destination = "LIS",
                                    flightNumber = "FR 2263",
                                    time = listOf(
                                        "2024-07-01T05:45:00.000",
                                        "2024-07-01T09:00:00.000"
                                    ),
                                    timeUTC = listOf(
                                        "2024-07-01T03:45:00.000Z",
                                        "2024-07-01T08:00:00.000Z"
                                    ),
                                    duration = "04:15"
                                )
                            ),
                            flightNumber = "FR 2263",
                            time = listOf(
                                "2024-07-01T05:45:00.000",
                                "2024-07-01T09:00:00.000"
                            ),
                            timeUTC = listOf(
                                "2024-07-01T03:45:00.000Z",
                                "2024-07-01T08:00:00.000Z"
                            ),
                            duration = "04:15"
                        )
                    )
                )
            )
        ),
        RyanairTripsResponse.Trip(
            origin = "LIS",
            originName = "Lisbon ",
            destination = "WMI",
            destinationName = "Warsaw (Modlin)",
            routeGroup = "LEISURE",
            tripType = "SUN_BREAK",
            upgradeType = "PLUS",
            dates = listOf(
                RyanairTripsResponse.Trip.Date(
                    dateOut = "2024-07-11T00:00:00.000",
                    flights = listOf(
                        RyanairTripsResponse.Trip.Date.Flight(
                            faresLeft = 2,
                            flightKey = "FR~2264~ ~~LIS~07/11/2024 15:00~WMI~07/11/2024 20:00~~",
                            infantsLeft = 18,
                            regularFare = RyanairTripsResponse.Trip.Date.Flight.RegularFare(
                                fareKey = "",
                                fareClass = "P",
                                fares = listOf(
                                    RyanairTripsResponse.Trip.Date.Flight.RegularFare.Fare(
                                        type = "ADT",
                                        amount = 904.0,
                                        count = 1,
                                        hasDiscount = false,
                                        publishedFare = 904.0,
                                        discountInPercent = 0,
                                        hasPromoDiscount = false,
                                        discountAmount = 0,
                                        hasBogof = false
                                    )
                                )
                            ),
                            operatedBy = "Buzz",
                            segments = listOf(
                                RyanairTripsResponse.Trip.Date.Flight.Segment(
                                    segmentNr = 0,
                                    origin = "LIS",
                                    destination = "WMI",
                                    flightNumber = "FR 2264",
                                    time = listOf(
                                        "2024-07-11T15:00:00.000",
                                        "2024-07-11T20:00:00.000"
                                    ),
                                    timeUTC = listOf(
                                        "2024-07-11T14:00:00.000Z",
                                        "2024-07-11T18:00:00.000Z"
                                    ),
                                    duration = "04:00"
                                )
                            ),
                            flightNumber = "FR 2264",
                            time = listOf(
                                "2024-07-11T15:00:00.000",
                                "2024-07-11T20:00:00.000"
                            ),
                            timeUTC = listOf(
                                "2024-07-11T14:00:00.000Z",
                                "2024-07-11T18:00:00.000Z"
                            ),
                            duration = "04:00"
                        )
                    )
                )
            )
        )
    ),
    serverTimeUTC = "2024-06-17T10:57:54.043Z",
)

val ryanairInternalTripsResponse = TripsInternalResponse(
    trips = listOf(
        TripsInternalResponse.Trip(
            originAirportCode = AirportCode("WMI"),
            destinationAirportCode = AirportCode("LIS"),
            totalDuration = 4.hours.toJavaDuration() + 15.minutes.toJavaDuration(),
            segments = listOf(
                TripsInternalResponse.FlightSegment.FlightSegmentId("WMI-LIS-2024-07-01T05:45:00.000"),
            ),
            price = TripsInternalResponse.Trip.TripPrice(
                totalInCents = 61400,
                currency = "PLN",
            )
        ),
        TripsInternalResponse.Trip(
            originAirportCode = AirportCode("LIS"),
            destinationAirportCode = AirportCode("WMI"),
            totalDuration = 4.hours.toJavaDuration(),
            segments = listOf(
                TripsInternalResponse.FlightSegment.FlightSegmentId("LIS-WMI-2024-07-11T15:00:00.000"),
            ),
            price = TripsInternalResponse.Trip.TripPrice(
                totalInCents = 90400,
                currency = "PLN",
            )
        )
    ),
    dictionaries = TripsInternalResponse.Dictionary(
        segments = listOf(
            TripsInternalResponse.FlightSegment(
                id = TripsInternalResponse.FlightSegment.FlightSegmentId("WMI-LIS-2024-07-01T05:45:00.000"),
                flightNumber = "FR 2263",
                departure = TripsInternalResponse.FlightSegment.PointInTime(
                    airportCode = AirportCode("WMI"),
                    dateTime = OffsetDateTime.parse("2024-07-01T05:45+02:00"),
                ),
                arrival = TripsInternalResponse.FlightSegment.PointInTime(
                    airportCode = AirportCode("LIS"),
                    dateTime = OffsetDateTime.parse("2024-07-01T09:00+01:00"),
                ),
                duration = 4.hours.toJavaDuration() + 15.minutes.toJavaDuration(),
                airline = TripsInternalResponse.FlightSegment.Airline(
                    name = "Ryanair",
                    code = TripsInternalResponse.FlightSegment.AirlineCode("FR"),
                ),
            ),
            TripsInternalResponse.FlightSegment(
                id = TripsInternalResponse.FlightSegment.FlightSegmentId("LIS-WMI-2024-07-11T15:00:00.000"),
                flightNumber = "FR 2264",
                departure = TripsInternalResponse.FlightSegment.PointInTime(
                    airportCode = AirportCode("LIS"),
                    dateTime = OffsetDateTime.parse("2024-07-11T15:00+01:00"),
                ),
                arrival = TripsInternalResponse.FlightSegment.PointInTime(
                    airportCode = AirportCode("WMI"),
                    dateTime = OffsetDateTime.parse("2024-07-11T20:00+02:00"),
                ),
                duration = 4.hours.toJavaDuration(),
                airline = TripsInternalResponse.FlightSegment.Airline(
                    name = "Ryanair",
                    code = TripsInternalResponse.FlightSegment.AirlineCode("FR"),
                ),
            )
        )
    )

)