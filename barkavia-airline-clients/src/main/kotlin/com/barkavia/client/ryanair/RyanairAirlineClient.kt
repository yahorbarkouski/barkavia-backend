package com.barkavia.client.ryanair

import com.barkavia.client.common.AirlineClient
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class RyanairAirlineClient(
    @Value("\${api.clients.ryanair.baseUrl}")
    private val baseUrl: String,
    @Value("\${api.clients.ryanair.cookie}")
    private val cookie: String,
) : AirlineClient<RyanairSearchTripsRequest, RyanairTripsResponse>() {

    private val log: Logger = LoggerFactory.getLogger(RyanairAirlineClient::class.java)

    override suspend fun searchTrips(request: RyanairSearchTripsRequest): RyanairTripsResponse? {
        log.debug("Searching for Ryanair trips...")

        val apiRequest = Request.Builder()
            .url(request.asQueryUrl(baseUrl)).get()
            .addHeadersWithCookie(cookie)
            .build()

        val response = okHttpClient.newCall(apiRequest).execute()
        val responseBody = response.body?.string()
        if (!response.isSuccessful) {
            log.warn("Failed to get response from Ryanair API: $responseBody")
            return null
        }

        return responseBody?.let { objectMapper.readValue(it) }
    }

    private fun RyanairSearchTripsRequest.asQueryUrl(baseUrl: String): String {
        return "$baseUrl/api/booking/v4/en-gb/availability" +
                "?adults=$numberOfPassengers" +
                "&dateOut=$departureDate" +
                "&dateIn=$returnDate" +
                "&Destination=$destination" +
                "&Origin=$origin" +
                "&IncludeConnectingFlights=true" +
                "&ToUs=AGREED" +
                "&roundTrip=true" +
                "&currency=EUR"
    }

    private fun Request.Builder.addHeadersWithCookie(cookie: String): Request.Builder {
        return this
            .addHeader("accept", "application/json, text/plain, */*")
            .addHeader("cookie", cookie)
    }
}