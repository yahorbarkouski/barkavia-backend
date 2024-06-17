package com.barkavia.client.common

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Autowired

abstract class AirlineClient<RequestType, ResponseType> {

    @Autowired
    lateinit var okHttpClient: OkHttpClient
    @Autowired
    lateinit var objectMapper: ObjectMapper

    abstract suspend fun searchTrips(request: RequestType): ResponseType?
}
