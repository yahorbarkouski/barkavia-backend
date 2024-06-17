package com.barkavia.api.search.dispatcher.service

import com.barkavia.client.lot.LotAirlineApiMapper
import com.barkavia.client.lot.LotAirlineClient
import com.barkavia.client.lot.LotSearchTripsRequest
import com.barkavia.client.lot.LotTripsResponse
import org.springframework.stereotype.Component

@Component
internal class LotTripSearchService(
    private val mapper: LotAirlineApiMapper,
    private val client: LotAirlineClient,
) : TripsSearchService<LotSearchTripsRequest, LotTripsResponse>() {

    override fun getMapper() = mapper

    override fun getClient() = client
}
