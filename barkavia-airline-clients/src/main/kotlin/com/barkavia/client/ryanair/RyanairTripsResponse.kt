package com.barkavia.client.ryanair

data class RyanairTripsResponse(
    val currency: String,
    val currPrecision: Int,
    val routeGroup: String,
    val tripType: String,
    val upgradeType: String,
    val trips: List<Trip>,
    val serverTimeUTC: String
) {
    data class Trip(
        val origin: String,
        val originName: String,
        val destination: String,
        val destinationName: String,
        val routeGroup: String,
        val tripType: String,
        val upgradeType: String,
        val dates: List<Date>
    ) {
        data class Date(
            val dateOut: String,
            val flights: List<Flight>
        ) {
            data class Flight(
                val faresLeft: Int,
                val flightKey: String,
                val infantsLeft: Int,
                val regularFare: RegularFare?,
                val operatedBy: String,
                val segments: List<Segment>,
                val flightNumber: String,
                val time: List<String>,
                val timeUTC: List<String>,
                val duration: String
            ) {
                data class RegularFare(
                    val fareKey: String,
                    val fareClass: String,
                    val fares: List<Fare>
                ) {
                    data class Fare(
                        val type: String,
                        val amount: Double,
                        val count: Int,
                        val hasDiscount: Boolean,
                        val publishedFare: Double,
                        val discountInPercent: Int,
                        val hasPromoDiscount: Boolean,
                        val discountAmount: Int,
                        val hasBogof: Boolean
                    )
                }

                data class Segment(
                    val segmentNr: Int,
                    val origin: String,
                    val destination: String,
                    val flightNumber: String,
                    val time: List<String>,
                    val timeUTC: List<String>,
                    val duration: String
                )
            }
        }
    }
}
