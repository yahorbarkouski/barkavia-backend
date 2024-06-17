package com.barkavia.client.ryanair

import org.intellij.lang.annotations.Language

@Language("JSON")
internal const val ryanairSearchTripsOkResponseRaw = """
{
  "termsOfUse": "https://www.ryanair.com/ie/en/corporate/terms-of-use=AGREED",
  "currency": "PLN",
  "currPrecision": 2,
  "routeGroup": "LEISURE",
  "tripType": "SUN_BREAK",
  "upgradeType": "PLUS",
  "trips": [
    {
      "origin": "WMI",
      "originName": "Warsaw (Modlin)",
      "destination": "LIS",
      "destinationName": "Lisbon ",
      "routeGroup": "LEISURE",
      "tripType": "SUN_BREAK",
      "upgradeType": "PLUS",
      "dates": [
        {
          "dateOut": "2024-07-01T00:00:00.000",
          "flights": [
            {
              "faresLeft": 5,
              "flightKey": "FR~2263~ ~~WMI~07/01/2024 05:45~LIS~07/01/2024 09:00~~",
              "infantsLeft": 17,
              "regularFare": {
                "fareKey": "",
                "fareClass": "V",
                "fares": [
                  {
                    "type": "ADT",
                    "amount": 614,
                    "count": 1,
                    "hasDiscount": false,
                    "publishedFare": 614,
                    "discountInPercent": 0,
                    "hasPromoDiscount": false,
                    "discountAmount": 0,
                    "hasBogof": false
                  }
                ]
              },
              "operatedBy": "Buzz",
              "segments": [
                {
                  "segmentNr": 0,
                  "origin": "WMI",
                  "destination": "LIS",
                  "flightNumber": "FR 2263",
                  "time": [
                    "2024-07-01T05:45:00.000",
                    "2024-07-01T09:00:00.000"
                  ],
                  "timeUTC": [
                    "2024-07-01T03:45:00.000Z",
                    "2024-07-01T08:00:00.000Z"
                  ],
                  "duration": "04:15"
                }
              ],
              "flightNumber": "FR 2263",
              "time": [
                "2024-07-01T05:45:00.000",
                "2024-07-01T09:00:00.000"
              ],
              "timeUTC": [
                "2024-07-01T03:45:00.000Z",
                "2024-07-01T08:00:00.000Z"
              ],
              "duration": "04:15"
            }
          ]
        }
      ]
    },
    {
      "origin": "LIS",
      "originName": "Lisbon ",
      "destination": "WMI",
      "destinationName": "Warsaw (Modlin)",
      "routeGroup": "LEISURE",
      "tripType": "SUN_BREAK",
      "upgradeType": "PLUS",
      "dates": [
        {
          "dateOut": "2024-07-11T00:00:00.000",
          "flights": [
            {
              "faresLeft": 2,
              "flightKey": "FR~2264~ ~~LIS~07/11/2024 15:00~WMI~07/11/2024 20:00~~",
              "infantsLeft": 18,
              "regularFare": {
                "fareKey": "",
                "fareClass": "P",
                "fares": [
                  {
                    "type": "ADT",
                    "amount": 904,
                    "count": 1,
                    "hasDiscount": false,
                    "publishedFare": 904,
                    "discountInPercent": 0,
                    "hasPromoDiscount": false,
                    "discountAmount": 0,
                    "hasBogof": false
                  }
                ]
              },
              "operatedBy": "Buzz",
              "segments": [
                {
                  "segmentNr": 0,
                  "origin": "LIS",
                  "destination": "WMI",
                  "flightNumber": "FR 2264",
                  "time": [
                    "2024-07-11T15:00:00.000",
                    "2024-07-11T20:00:00.000"
                  ],
                  "timeUTC": [
                    "2024-07-11T14:00:00.000Z",
                    "2024-07-11T18:00:00.000Z"
                  ],
                  "duration": "04:00"
                }
              ],
              "flightNumber": "FR 2264",
              "time": [
                "2024-07-11T15:00:00.000",
                "2024-07-11T20:00:00.000"
              ],
              "timeUTC": [
                "2024-07-11T14:00:00.000Z",
                "2024-07-11T18:00:00.000Z"
              ],
              "duration": "04:00"
            }
          ]
        }
      ]
    }
  ],
  "serverTimeUTC": "2024-06-17T10:57:54.043Z"
}    
"""

@Language("JSON")
internal const val ryanairSearchTripsBadRequestResponseRaw = """
{
  "code": "InvalidRequestFields",
  "message": "InvalidRequestFields"
}
"""
