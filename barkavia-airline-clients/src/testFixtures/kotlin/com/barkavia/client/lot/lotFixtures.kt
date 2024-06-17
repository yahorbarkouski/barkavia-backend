package com.barkavia.client.lot

import com.barkavia.client.common.AirportCode
import com.barkavia.client.common.TripsInternalResponse
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

val lotSearchTripsOkResponse = LotTripsResponse(
    data = LotTripsResponse.Data(
        airBoundFlights = listOf(
            LotTripsResponse.Data.LotFlightResponse(
                flight = LotTripsResponse.Data.Flight(
                    originLocationCode = "WAW",
                    destinationLocationCode = "LHR",
                    duration = 10500,
                    ranking = 1,
                    segments = listOf(
                        LotTripsResponse.Data.SegmentShorted(
                            segmentId = "SEG-LO281-WAWLHR-2024-06-21-0725",
                            connectionTime = null
                        )
                    )
                ),
                airBoundOffers = listOf(
                    // SAVER Offer
                    LotTripsResponse.Data.AirBoundOffer(
                        airBoundOfferId = "BC1-2-OFR-903140959299843-1-1-1",
                        fareFamilyCode = "SAVER",
                        isCheapestOffer = true,
                        availabilityDetails = listOf(
                            LotTripsResponse.Data.AvailabilityDetail(
                                segmentId = "SEG-LO281-WAWLHR-2024-06-21-0725",
                                compartment = "ECONOMY",
                                bookingClass = "V",
                                statusCode = "HK",
                                quota = 9,
                                mileageAccrual = 500
                            )
                        ),
                        fareInfos = listOf(
                            LotTripsResponse.Data.FareInfo(
                                fareType = "public",
                                fareClass = "VSAVN0",
                                pricedPassengerTypeCodes = listOf("ADT"),
                                travelerIds = listOf("ADT-1"),
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        prices = LotTripsResponse.Data.Prices(
                            unitPrices = listOf(
                                LotTripsResponse.Data.UnitPrice(
                                    travelerIds = listOf("ADT-1"),
                                    prices = listOf(
                                        LotTripsResponse.Data.Price(
                                            base = 43500,
                                            total = 54511,
                                            currencyCode = "PLN",
                                            totalTaxes = 11011
                                        )
                                    )
                                )
                            ),
                            totalPrices = listOf(
                                LotTripsResponse.Data.TotalPrice(
                                    base = 43500,
                                    total = 54511,
                                    currencyCode = "PLN",
                                    taxes = listOf(
                                        LotTripsResponse.Data.Tax(
                                            value = 2172,
                                            currencyCode = "PLN",
                                            code = "YQYR"
                                        )
                                    ),
                                    totalTaxes = 11011
                                )
                            )
                        ),
                        services = listOf(
                            LotTripsResponse.Data.Service(
                                serviceCode = "FBA1",
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        upgrade = LotTripsResponse.Data.Upgrade(
                            targetAirBoundOfferId = "BC1-2-OFR-903140959299843-8-1-1",
                            targetCompartment = "BUSINESS",
                            priceDifference = listOf(
                                LotTripsResponse.Data.PriceDifference(
                                    currencyCode = "PLN",
                                    total = 50513,
                                    travelerId = "ADT-1"
                                )
                            )
                        )
                    ),
                    // STANDARD Offer
                    LotTripsResponse.Data.AirBoundOffer(
                        airBoundOfferId = "BC1-2-OFR-903140959299843-2-1-1",
                        fareFamilyCode = "STANDARD",
                        isCheapestOffer = false,
                        availabilityDetails = listOf(
                            LotTripsResponse.Data.AvailabilityDetail(
                                segmentId = "SEG-LO281-WAWLHR-2024-06-21-0725",
                                compartment = "ECONOMY",
                                bookingClass = "V",
                                statusCode = "HK",
                                quota = 9,
                                mileageAccrual = 500
                            )
                        ),
                        fareInfos = listOf(
                            LotTripsResponse.Data.FareInfo(
                                fareType = "public",
                                fareClass = "VSTDN0",
                                pricedPassengerTypeCodes = listOf("ADT"),
                                travelerIds = listOf("ADT-1"),
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        prices = LotTripsResponse.Data.Prices(
                            unitPrices = listOf(
                                LotTripsResponse.Data.UnitPrice(
                                    travelerIds = listOf("ADT-1"),
                                    prices = listOf(
                                        LotTripsResponse.Data.Price(
                                            base = 52500,
                                            total = 63511,
                                            currencyCode = "PLN",
                                            totalTaxes = 11011
                                        )
                                    )
                                )
                            ),
                            totalPrices = listOf(
                                LotTripsResponse.Data.TotalPrice(
                                    base = 52500,
                                    total = 63511,
                                    currencyCode = "PLN",
                                    taxes = listOf(
                                        LotTripsResponse.Data.Tax(
                                            value = 2172,
                                            currencyCode = "PLN",
                                            code = "YQYR"
                                        )
                                    ),
                                    totalTaxes = 11011
                                )
                            )
                        ),
                        services = listOf(
                            LotTripsResponse.Data.Service(
                                serviceCode = "FBA2-C0GOC1-0DCC2-0DDC3-0F8C4",
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        upgrade = LotTripsResponse.Data.Upgrade(
                            targetAirBoundOfferId = "BC1-2-OFR-903140959299843-11-1-1",
                            targetCompartment = "BUSINESS",
                            priceDifference = listOf(
                                LotTripsResponse.Data.PriceDifference(
                                    currencyCode = "PLN",
                                    total = 61513,
                                    travelerId = "ADT-1"
                                )
                            )
                        )
                    ),
                    // FLEX Offer
                    LotTripsResponse.Data.AirBoundOffer(
                        airBoundOfferId = "BC1-2-OFR-903140959299843-5-1-1",
                        fareFamilyCode = "FLEX",
                        isCheapestOffer = false,
                        availabilityDetails = listOf(
                            LotTripsResponse.Data.AvailabilityDetail(
                                segmentId = "SEG-LO281-WAWLHR-2024-06-21-0725",
                                compartment = "ECONOMY",
                                bookingClass = "V",
                                statusCode = "HK",
                                quota = 9,
                                mileageAccrual = 500
                            )
                        ),
                        fareInfos = listOf(
                            LotTripsResponse.Data.FareInfo(
                                fareType = "public",
                                fareClass = "VFLXN0",
                                pricedPassengerTypeCodes = listOf("ADT"),
                                travelerIds = listOf("ADT-1"),
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        prices = LotTripsResponse.Data.Prices(
                            unitPrices = listOf(
                                LotTripsResponse.Data.UnitPrice(
                                    travelerIds = listOf("ADT-1"),
                                    prices = listOf(
                                        LotTripsResponse.Data.Price(
                                            base = 65500,
                                            total = 76511,
                                            currencyCode = "PLN",
                                            totalTaxes = 11011
                                        )
                                    )
                                )
                            ),
                            totalPrices = listOf(
                                LotTripsResponse.Data.TotalPrice(
                                    base = 65500,
                                    total = 76511,
                                    currencyCode = "PLN",
                                    taxes = listOf(
                                        LotTripsResponse.Data.Tax(
                                            value = 2172,
                                            currencyCode = "PLN",
                                            code = "YQYR"
                                        )
                                    ),
                                    totalTaxes = 11011
                                )
                            )
                        ),
                        services = listOf(
                            LotTripsResponse.Data.Service(
                                serviceCode = "FBA2-C0GOC1-0DCC2-0DDC3-0F8C4",
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        upgrade = LotTripsResponse.Data.Upgrade(
                            targetAirBoundOfferId = "BC1-2-OFR-903140959299843-11-1-1",
                            targetCompartment = "BUSINESS",
                            priceDifference = listOf(
                                LotTripsResponse.Data.PriceDifference(
                                    currencyCode = "PLN",
                                    total = 48513,
                                    travelerId = "ADT-1"
                                )
                            )
                        )
                    ),
                    // BIZSTD Offer
                    LotTripsResponse.Data.AirBoundOffer(
                        airBoundOfferId = "BC1-2-OFR-903140959299843-8-1-1",
                        fareFamilyCode = "BIZSTD",
                        isCheapestOffer = false,
                        availabilityDetails = listOf(
                            LotTripsResponse.Data.AvailabilityDetail(
                                segmentId = "SEG-LO281-WAWLHR-2024-06-21-0725",
                                compartment = "BUSINESS",
                                bookingClass = "Z",
                                statusCode = "HK",
                                quota = 9,
                                mileageAccrual = 1250
                            )
                        ),
                        fareInfos = listOf(
                            LotTripsResponse.Data.FareInfo(
                                fareType = "public",
                                fareClass = "ZSFXB0",
                                pricedPassengerTypeCodes = listOf("ADT"),
                                travelerIds = listOf("ADT-1"),
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        prices = LotTripsResponse.Data.Prices(
                            unitPrices = listOf(
                                LotTripsResponse.Data.UnitPrice(
                                    travelerIds = listOf("ADT-1"),
                                    prices = listOf(
                                        LotTripsResponse.Data.Price(
                                            base = 87500,
                                            total = 105024,
                                            currencyCode = "PLN",
                                            totalTaxes = 17524
                                        )
                                    )
                                )
                            ),
                            totalPrices = listOf(
                                LotTripsResponse.Data.TotalPrice(
                                    base = 87500,
                                    total = 105024,
                                    currencyCode = "PLN",
                                    taxes = listOf(
                                        LotTripsResponse.Data.Tax(
                                            value = 8685,
                                            currencyCode = "PLN",
                                            code = "YQYR"
                                        )
                                    ),
                                    totalTaxes = 17524
                                )
                            )
                        ),
                        services = listOf(
                            LotTripsResponse.Data.Service(
                                serviceCode = "FBA3-0FMC5",
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        upgrade = null
                    ),
                    // BIZFLX Offer
                    LotTripsResponse.Data.AirBoundOffer(
                        airBoundOfferId = "BC1-2-OFR-903140959299843-11-1-1",
                        fareFamilyCode = "BIZFLX",
                        isCheapestOffer = false,
                        availabilityDetails = listOf(
                            LotTripsResponse.Data.AvailabilityDetail(
                                segmentId = "SEG-LO281-WAWLHR-2024-06-21-0725",
                                compartment = "BUSINESS",
                                bookingClass = "Z",
                                statusCode = "HK",
                                quota = 9,
                                mileageAccrual = 1250
                            )
                        ),
                        fareInfos = listOf(
                            LotTripsResponse.Data.FareInfo(
                                fareType = "public",
                                fareClass = "ZFFXB0",
                                pricedPassengerTypeCodes = listOf("ADT"),
                                travelerIds = listOf("ADT-1"),
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        prices = LotTripsResponse.Data.Prices(
                            unitPrices = listOf(
                                LotTripsResponse.Data.UnitPrice(
                                    travelerIds = listOf("ADT-1"),
                                    prices = listOf(
                                        LotTripsResponse.Data.Price(
                                            base = 107500,
                                            total = 125024,
                                            currencyCode = "PLN",
                                            totalTaxes = 17524
                                        )
                                    )
                                )
                            ),
                            totalPrices = listOf(
                                LotTripsResponse.Data.TotalPrice(
                                    base = 107500,
                                    total = 125024,
                                    currencyCode = "PLN",
                                    taxes = listOf(
                                        LotTripsResponse.Data.Tax(
                                            value = 8685,
                                            currencyCode = "PLN",
                                            code = "YQYR"
                                        )
                                    ),
                                    totalTaxes = 17524
                                )
                            )
                        ),
                        services = listOf(
                            LotTripsResponse.Data.Service(
                                serviceCode = "FBA3-0FMC5",
                                segmentIds = listOf("SEG-LO281-WAWLHR-2024-06-21-0725")
                            )
                        ),
                        upgrade = null
                    )
                ),
                compartments = listOf(
                    LotTripsResponse.Data.Compartment(
                        compartmentName = "BUSINESS",
                        status = "AVAILABLE"
                    ),
                    LotTripsResponse.Data.Compartment(
                        compartmentName = "ECONOMY",
                        status = "AVAILABLE"
                    )
                ),
                hasCheapestOffer = true,
                isCodeShare = false
            )
        )
    ),
    dictionaries = LotTripsResponse.Dictionaries(
        airline = mapOf("LO" to "LOT POLISH AIRLINES"),
        aircraft = mapOf("7M8" to "BOEING 737 MAX 8"),
        segment = mapOf(
            "SEG-LO281-WAWLHR-2024-06-21-0725" to LotTripsResponse.Dictionaries.LotSegment(
                marketingAirlineCode = "LO",
                operatingAirlineCode = "LO",
                marketingFlightNumber = "281",
                departure = LotTripsResponse.Dictionaries.LotSegment.LotSegmentPointInTime(
                    locationCode = "WAW",
                    dateTime = "2024-06-21T07:25:00+02:00",
                    terminal = null
                ),
                arrival = LotTripsResponse.Dictionaries.LotSegment.LotSegmentPointInTime(
                    locationCode = "LHR",
                    dateTime = "2024-06-21T09:20:00+01:00",
                    terminal = "2"
                ),
                aircraftCode = "7M8",
                duration = 10500,
                secureFlightIndicator = false,
                features = listOf(
                    LotTripsResponse.Dictionaries.LotSegment.LotSegmentFeature(
                        title = "E-press",
                        applicability = "included"
                    ),
                    LotTripsResponse.Dictionaries.LotSegment.LotSegmentFeature(
                        title = "1 x snack, 1 x drink",
                        applicability = "included"
                    ),
                    LotTripsResponse.Dictionaries.LotSegment.LotSegmentFeature(
                        title = "Onboard entertainment",
                        applicability = "included"
                    )
                )
            )
        )
    )
)

val lotInternalTripsResponse = TripsInternalResponse(
    trips = listOf(
        TripsInternalResponse.Trip(
            originAirportCode = AirportCode("WAW"),
            destinationAirportCode = AirportCode("LHR"),
            totalDuration = Duration.ofMinutes(175),
            segments = listOf(TripsInternalResponse.FlightSegment.FlightSegmentId("SEG-LO281-WAWLHR-2024-06-21-0725")),
            price = TripsInternalResponse.Trip.TripPrice(
                totalInCents = 54511,
                currency = "PLN"
            )
        )
    ),
    dictionaries = TripsInternalResponse.Dictionary(
        segments = listOf(
            TripsInternalResponse.FlightSegment(
                id = TripsInternalResponse.FlightSegment.FlightSegmentId("SEG-LO281-WAWLHR-2024-06-21-0725"),
                flightNumber = "LO281",
                departure = TripsInternalResponse.FlightSegment.PointInTime(
                    airportCode = AirportCode("WAW"),
                    dateTime = OffsetDateTime.parse("2024-06-21T07:25+02:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    terminal = null
                ),
                arrival = TripsInternalResponse.FlightSegment.PointInTime(
                    airportCode = AirportCode("LHR"),
                    dateTime = OffsetDateTime.parse("2024-06-21T09:20+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    terminal = "2"
                ),
                duration = Duration.ofMinutes(175),
                aircraft = TripsInternalResponse.FlightSegment.Aircraft(
                    name = "BOEING 737 MAX 8",
                    code = "7M8",
                    features = listOf(
                        TripsInternalResponse.FlightSegment.Aircraft.AircraftFeatures(
                            title = "E-press",
                            applicability = "included"
                        ),
                        TripsInternalResponse.FlightSegment.Aircraft.AircraftFeatures(
                            title = "1 x snack, 1 x drink",
                            applicability = "included"
                        ),
                        TripsInternalResponse.FlightSegment.Aircraft.AircraftFeatures(
                            title = "Onboard entertainment",
                            applicability = "included"
                        )
                    )
                ),
                airline = TripsInternalResponse.FlightSegment.Airline(
                    code = TripsInternalResponse.FlightSegment.AirlineCode("LO"),
                    name = "LOT POLISH AIRLINES"
                )
            )
        )
    )
)