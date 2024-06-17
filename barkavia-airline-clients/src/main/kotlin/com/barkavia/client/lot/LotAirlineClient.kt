package com.barkavia.client.lot

import com.barkavia.client.common.AirlineClient
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class LotAirlineClient(
    @Value("\${api.clients.lot.baseUrl}")
    private val baseUrl: String
) : AirlineClient<LotSearchTripsRequest, LotTripsResponse>() {

    private val log: Logger = LoggerFactory.getLogger(LotAirlineClient::class.java)

    override suspend fun searchTrips(request: LotSearchTripsRequest): LotTripsResponse? {
        log.info("Searching for Lot Airline trips...")
        val body = objectMapper.writeValueAsString(request).toRequestBody("application/json".toMediaType())

        val apiRequest = Request.Builder()
            .url("$baseUrl/api/v1/ibe/search/air-bounds")
            .post(body)
            .addHeader("accept", "application/json")
            .addHeader(
                "accept-language",
                "ru-BY,ru-RU;q=0.9,ru;q=0.8,en-US;q=0.7,en;q=0.6,zh-CN;q=0.5,zh-TW;q=0.4,zh;q=0.3"
            )
            .addHeader("action", "DO_SEARCH")
            .addHeader("cache-control", "no-cache")
            .addHeader("channel", "1")
            .addHeader("language", "en")
            .addHeader("market", "pl")
            .addHeader("origin", "https://www.lot.com")
            .addHeader("pragma", "no-cache")
            .addHeader("priority", "u=1, i")
            .addHeader("referer", "https://www.lot.com/pl/en/book/availability/departure")
            .addHeader("remoteip", "127.0.0.1")
            .addHeader("sec-ch-ua-mobile", "?0")
            .addHeader("sec-ch-ua-platform", "\"macOS\"")
            .addHeader("sec-fetch-dest", "empty")
            .addHeader("sec-fetch-mode", "cors")
            .addHeader("sec-fetch-site", "same-origin")
            .addHeader("step", "SEARCH")
            .addHeader(
                "user-agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36"
            )
            .addHeader("x-xsrf-token", "6+FA14DLkeZweizEow1ibc9LDIiqhbs+I74sEvgZ/cu4Qk2I4fCoZeuUVJcnwIll")
            .addHeader("Content-Type", "application/json")
            .build()

        val response = okHttpClient.newCall(apiRequest).execute()
        val responseString = response.body?.string()
        if (!response.isSuccessful) {
            log.warn("Failed to get response from Lot API: $responseString")
            return null
        }

        return objectMapper.readValue(responseString!!)
    }
}
