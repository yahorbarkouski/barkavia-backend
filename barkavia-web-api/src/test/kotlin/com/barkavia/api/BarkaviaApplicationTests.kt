package com.barkavia.api

import com.barkavia.api.search.dispatcher.service.TripsSearchService
import com.barkavia.client.lot.LotAirlineClient
import com.barkavia.client.ryanair.RyanairAirlineClient
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.runBlocking
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext
import kotlin.reflect.full.isSubclassOf

@SpringBootTest(
    classes = [
        BarkaviaApplication::class,
        AirlineTripsSearchServiceMockConfiguration::class
    ],
)
@WebAppConfiguration
@ActiveProfiles("local", "test")
abstract class IntegrationTest

abstract class EndpointTest : IntegrationTest() {

    protected lateinit var mockMvc: MockMvc

    @Autowired
    protected lateinit var objectMapper: ObjectMapper

    @Autowired
    private fun setMockMvc(webApplicationContext: WebApplicationContext) {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }

    @Bean
    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
        .registerModules(JavaTimeModule())
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
}

@TestConfiguration
internal class AirlineTripsSearchServiceMockConfiguration {

    @MockBean
    private lateinit var lotAirlineClient: LotAirlineClient
    @MockBean
    private lateinit var ryanairAirlineClient: RyanairAirlineClient
}
