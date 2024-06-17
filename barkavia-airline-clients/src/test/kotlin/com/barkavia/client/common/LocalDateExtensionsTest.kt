package com.barkavia.client.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LocalDateExtensionsTest {

    @Test
    fun `asIso8601 returns date in ISO 8601 format`() {
        val date = LocalDate.of(2024, 1, 30)

        assertEquals("2024-01-30", date.asIso8601())
    }
}
