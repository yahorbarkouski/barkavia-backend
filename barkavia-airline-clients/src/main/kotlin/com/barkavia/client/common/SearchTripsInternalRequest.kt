package com.barkavia.client.common

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class SearchTripsInternalRequest(
    val origin: AirportCode,
    val destination: AirportCode,
    val departureDate: LocalDate,
    val returnDate: LocalDate?,
    val numberOfPassengers: Int,
)

fun LocalDate.asIso8601(): String = this.format(DateTimeFormatter.ISO_LOCAL_DATE)
