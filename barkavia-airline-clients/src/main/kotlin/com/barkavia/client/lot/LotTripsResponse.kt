package com.barkavia.client.lot

data class LotTripsResponse(
    val data: Data,
    val dictionaries: Dictionaries,
) {

    data class Data(
        val airBoundFlights: List<LotFlightResponse>
    ) {

        data class LotFlightResponse(
            val flight: Flight,
            val airBoundOffers: List<AirBoundOffer>,
            val compartments: List<Compartment>,
            val hasCheapestOffer: Boolean,
            val isCodeShare: Boolean
        )

        data class Flight(
            val originLocationCode: String,
            val destinationLocationCode: String,
            val duration: Int,
            val ranking: Int,
            val segments: List<SegmentShorted>
        )

        data class SegmentShorted(
            val segmentId: String,
            val connectionTime: Int? = null
        )

        data class AirBoundOffer(
            val airBoundOfferId: String,
            val fareFamilyCode: String,
            val isCheapestOffer: Boolean,
            val availabilityDetails: List<AvailabilityDetail>,
            val fareInfos: List<FareInfo>,
            val prices: Prices,
            val services: List<Service>,
            val upgrade: Upgrade? = null
        )

        data class AvailabilityDetail(
            val segmentId: String,
            val compartment: String,
            val bookingClass: String,
            val statusCode: String,
            val quota: Int,
            val mileageAccrual: Int
        )

        data class FareInfo(
            val fareType: String,
            val fareClass: String,
            val pricedPassengerTypeCodes: List<String>,
            val travelerIds: List<String>,
            val segmentIds: List<String>
        )

        data class Prices(
            val unitPrices: List<UnitPrice>,
            val totalPrices: List<TotalPrice>
        )

        data class UnitPrice(
            val travelerIds: List<String>,
            val prices: List<Price>
        )

        data class Price(
            val base: Int,
            val total: Int,
            val currencyCode: String,
            val totalTaxes: Int
        )

        data class TotalPrice(
            val base: Int,
            val total: Int,
            val currencyCode: String,
            val taxes: List<Tax>,
            val totalTaxes: Int
        )

        data class Tax(
            val value: Int,
            val currencyCode: String,
            val code: String
        )

        data class Service(
            val serviceCode: String,
            val segmentIds: List<String>
        )

        data class Upgrade(
            val targetAirBoundOfferId: String,
            val targetCompartment: String,
            val priceDifference: List<PriceDifference>
        )

        data class PriceDifference(
            val currencyCode: String,
            val total: Int,
            val travelerId: String
        )

        data class Compartment(
            val compartmentName: String,
            val status: String? = null,
        )
    }

    data class Dictionaries(
        val airline: Map<String, String>,
        val aircraft: Map<String, String>,
        val segment: Map<String, LotSegment>
    ) {

        data class LotSegment(
            val marketingAirlineCode: String,
            val operatingAirlineCode: String? = null,
            val marketingFlightNumber: String,
            val departure: LotSegmentPointInTime,
            val arrival: LotSegmentPointInTime,
            val aircraftCode: String,
            val duration: Int,
            val secureFlightIndicator: Boolean,
            val features: List<LotSegmentFeature>
        ) {

            data class LotSegmentPointInTime(
                val locationCode: String,
                val dateTime: String,
                val terminal: String? = null
            )

            data class LotSegmentFeature(
                val title: String,
                val applicability: String
            )
        }
    }
}