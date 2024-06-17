package com.barkavia.client.ryanair

data class RyanairSearchTripsRequest(
    val origin: String,
    val destination: String,
    val departureDate: String,
    val returnDate: String?,
    val numberOfPassengers: Int,
)