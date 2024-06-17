package com.barkavia.api

import com.barkavia.client.AirlineClientsModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(
    AirlineClientsModule::class,
)
class BarkaviaApplication

fun main(args: Array<String>) {
    runApplication<BarkaviaApplication>(*args)
}
