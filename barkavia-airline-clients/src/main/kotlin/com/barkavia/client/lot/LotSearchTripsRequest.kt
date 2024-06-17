package com.barkavia.client.lot

data class LotSearchTripsRequest(
    val travelers: List<String> = listOf("ADT"),
    val compartment: String,
    val itinerary: List<Itinerary>,
    val searchPreferences: Map<String, Any> = emptyMap(),
    val promotion: Any? = null
) {

    data class Itinerary(
        val originLocationCode: String,
        val destinationLocationCode: String,
        val departureDate: String,
        val isRequestedBound: Boolean
    )
}
