package com.barkavia.client

import com.github.tomakehurst.wiremock.WireMockServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    classes = [
        AirlineClientsModule::class,
    ]
)
@TestInstance(PER_CLASS)
@ActiveProfiles("local", "test")
internal abstract class AirlineClientIntegrationTest {

    protected val airlineClientServer: WireMockServer = WireMockServer(8060)

    @BeforeAll
    fun beforeAll() {
        airlineClientServer.start()
    }

    @AfterEach
    fun afterEach() {
        airlineClientServer.resetAll()
    }

    @AfterAll
    fun afterAll() {
        airlineClientServer.stop()
    }
}
