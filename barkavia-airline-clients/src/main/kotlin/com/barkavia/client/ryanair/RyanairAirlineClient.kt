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
    private val baseUrl: String
) : AirlineClient<RyanairSearchTripsRequest, RyanairTripsResponse>() {

    private val log: Logger = LoggerFactory.getLogger(RyanairAirlineClient::class.java)

    override suspend fun searchTrips(request: RyanairSearchTripsRequest): RyanairTripsResponse? {
        log.info("Searching for Ryanair trips...")
        val apiRequest = Request.Builder()
            .url("$baseUrl/api/booking/v4/en-gb/availability?adults=${request.numberOfPassengers}&dateOut=${request.departureDate}&dateIn=${request.returnDate}&Destination=${request.destination}&Origin=${request.origin}&IncludeConnectingFlights=true&ToUs=AGREED&roundTrip=true&currency=EUR")
            .get()
            .addHeader("accept", "application/json, text/plain, */*")
            .addHeader(
                "cookie",
                "rid=9d85db45-d38a-4784-b78b-1bc4684c2cc4; rid.sig=jyna6R42wntYgoTpqvxHMK7H+KyM6xLed+9I3KsvYZaVt7P36AL6zp9dGFPu5uVxaIiFpNXrszr+LfNCdY3IT3oCSYLeNv/ujtjsDqOzkY5JmUFsCdAEz3kpPbhCUwiArp5oaa75tpJtO3kFwYQ8l0DbH67AtcN/PMbniLsiM5qn+2AjrrtoNJicE3ZQwFHVipe4lWPSRfq2OIyUrlFhwEDt20+wCX7l1mCubNXtG6nZrUA07sFUFhn4RUxnjwjJ6d9qjjBasXLvYSqyYN7UaV6uR6GAL0/B/AbIcC0y9WQ2WtYWsGy+fTFoScQh77sejfaVKzOpLgWpzV9LAUFbBb+1BBCbheWzAtFAIHUgEjzuWPWbeS9iMiQeGM4PYsn6JeJ5bTKmo+eKrhOCFA1wUZR10dfG5WXjCKUIjzNFBnTD6Bz/JVdlXtCHyZfmfUChqoAS0GUyxLHz4OtYsajBX3snHdHFay/CakX7erHHgtLhOBxOV8bHGlMdLq1AOTK/M7LSJItk8gkRnI2UFrSJ6Tyyzrr4A1zuuuUJ3/SCFT7F71PdaSbH8MPoFZnkv5jh5hgDSSf1Tfjl7u+48LNKMI1wl5w/Sb+Q/13cuOl6YNgaRgZbF/rtjEDMqq2biO4gTqAVNz3hDUlKoj9TL7TrEDzwGzVDOnPog5Inc183s33hs0SgPdagWFeFSXx+X9ChUHYd4x+MlMfbUnnRLhWySoi5OhjHmqP0D0YkdDtvLu348/6mhm9Q1HDQr7bMxbzQ4Y3qAArv7SyDITx803M/q8kx23bs8ZbjLwfAxvst9abO+3Mf1qjqaxo7ZHViYtZ7qzSDnqjVUvLKqSNPqRa9eBAa2KEDux8w7638AIiPR9bUGCfNMsPMN2p0wAwmRmRyr5XRV1kMYt6tTvZdejFhZbQWOcQQXn3pooj/JBHN/i0dhCJ72VTWw/M2lKRcDnPyYqg3Kk5+uRnMvJZw9AcNHMTIAaOZneNy2keruYlKTpLvEhaMW2One0rJGRBpo78h1Vw3KZpPm5NqD2GPbDxyKw=="
            )
            .build()

        val response = okHttpClient.newCall(apiRequest).execute()
        val responseString = response.body?.string()
        if (!response.isSuccessful) {
            log.warn("Failed to get response from Ryanair API: $responseString")
            return null
        }

        return objectMapper.readValue(responseString!!)
    }
}