package com.barkavia.api.search.dispatcher.service

import com.barkavia.client.ryanair.RyanairAirlineApiMapper
import com.barkavia.client.ryanair.RyanairAirlineClient
import com.barkavia.client.ryanair.RyanairSearchTripsRequest
import com.barkavia.client.ryanair.RyanairTripsResponse
import org.springframework.stereotype.Component

@Component
internal class RyanairTripsSearchService(
    private val mapper: RyanairAirlineApiMapper,
    private val client: RyanairAirlineClient
) : TripsSearchService<RyanairSearchTripsRequest, RyanairTripsResponse>() {

    override fun getMapper() = mapper

    override fun getClient() = client
}
