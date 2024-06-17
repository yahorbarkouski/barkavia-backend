package com.barkavia.client.common

interface AirlineApiMapper<RequestType, ResponseType> {

    fun toSearchTripsRequest(request: SearchTripsInternalRequest): RequestType

    fun toTripsResponse(response: ResponseType): TripsInternalResponse
}
