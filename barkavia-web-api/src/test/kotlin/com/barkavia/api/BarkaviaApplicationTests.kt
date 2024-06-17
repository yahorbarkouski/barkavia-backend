package com.barkavia.api

import com.barkavia.client.lot.LotAirlineClient
import com.barkavia.client.ryanair.RyanairAirlineClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext

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
    private fun setMockMvc(webApplicationContext: WebApplicationContext) {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }
}

@TestConfiguration
internal class AirlineTripsSearchServiceMockConfiguration {

    @MockBean
    private lateinit var lotAirlineClient: LotAirlineClient

    @MockBean
    private lateinit var ryanairAirlineClient: RyanairAirlineClient
}
