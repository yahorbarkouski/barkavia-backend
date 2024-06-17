package com.barkavia.client.lot

import org.intellij.lang.annotations.Language

@Language("JSON")
val lotSearchTripsOkResponseRaw = """
{
  "errors": [],
  "warnings": [],
  "ibeFlowId": "iZIYCRUZmm",
  "data": {
    "airBoundFlights": [
      {
        "flight": {
          "originLocationCode": "WAW",
          "destinationLocationCode": "LHR",
          "duration": 10500,
          "ranking": 1,
          "segments": [
            {
              "segmentId": "SEG-LO281-WAWLHR-2024-06-21-0725"
            }
          ]
        },
        "airBoundOffers": [
          {
            "airBoundOfferId": "BC1-2-OFR-903140959299843-1-1-1",
            "fareFamilyCode": "SAVER",
            "isCheapestOffer": true,
            "availabilityDetails": [
              {
                "segmentId": "SEG-LO281-WAWLHR-2024-06-21-0725",
                "compartment": "ECONOMY",
                "bookingClass": "V",
                "statusCode": "HK",
                "quota": 9,
                "mileageAccrual": 500
              }
            ],
            "fareInfos": [
              {
                "fareType": "public",
                "fareClass": "VSAVN0",
                "pricedPassengerTypeCodes": [
                  "ADT"
                ],
                "travelerIds": [
                  "ADT-1"
                ],
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "prices": {
              "unitPrices": [
                {
                  "travelerIds": [
                    "ADT-1"
                  ],
                  "prices": [
                    {
                      "base": 43500,
                      "total": 54511,
                      "currencyCode": "PLN",
                      "totalTaxes": 11011,
                      "baseInMiles": 33391
                    }
                  ]
                }
              ],
              "totalPrices": [
                {
                  "base": 43500,
                  "total": 54511,
                  "currencyCode": "PLN",
                  "taxes": [
                    {
                      "value": 2172,
                      "currencyCode": "PLN",
                      "code": "YQYR"
                    }
                  ],
                  "totalTaxes": 11011,
                  "baseInMiles": 33391
                }
              ]
            },
            "services": [
              {
                "serviceCode": "FBA1",
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "upgrade": {
              "targetAirBoundOfferId": "BC1-2-OFR-903140959299843-8-1-1",
              "targetCompartment": "BUSINESS",
              "priceDifference": [
                {
                  "currencyCode": "PLN",
                  "total": 50513,
                  "travelerId": "ADT-1"
                }
              ]
            }
          },
          {
            "airBoundOfferId": "BC1-2-OFR-903140959299843-2-1-1",
            "fareFamilyCode": "STANDARD",
            "isCheapestOffer": false,
            "availabilityDetails": [
              {
                "segmentId": "SEG-LO281-WAWLHR-2024-06-21-0725",
                "compartment": "ECONOMY",
                "bookingClass": "V",
                "statusCode": "HK",
                "quota": 9,
                "mileageAccrual": 500
              }
            ],
            "fareInfos": [
              {
                "fareType": "public",
                "fareClass": "VSTDN0",
                "pricedPassengerTypeCodes": [
                  "ADT"
                ],
                "travelerIds": [
                  "ADT-1"
                ],
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "prices": {
              "unitPrices": [
                {
                  "travelerIds": [
                    "ADT-1"
                  ],
                  "prices": [
                    {
                      "base": 52500,
                      "total": 63511,
                      "currencyCode": "PLN",
                      "totalTaxes": 11011,
                      "baseInMiles": 40299
                    }
                  ]
                }
              ],
              "totalPrices": [
                {
                  "base": 52500,
                  "total": 63511,
                  "currencyCode": "PLN",
                  "taxes": [
                    {
                      "value": 2172,
                      "currencyCode": "PLN",
                      "code": "YQYR"
                    }
                  ],
                  "totalTaxes": 11011,
                  "baseInMiles": 40299
                }
              ]
            },
            "services": [
              {
                "serviceCode": "FBA2-C0GOC1-0DCC2-0DDC3-0F8C4",
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "upgrade": {
              "targetAirBoundOfferId": "BC1-2-OFR-903140959299843-11-1-1",
              "targetCompartment": "BUSINESS",
              "priceDifference": [
                {
                  "currencyCode": "PLN",
                  "total": 61513,
                  "travelerId": "ADT-1"
                }
              ]
            }
          },
          {
            "airBoundOfferId": "BC1-2-OFR-903140959299843-5-1-1",
            "fareFamilyCode": "FLEX",
            "isCheapestOffer": false,
            "availabilityDetails": [
              {
                "segmentId": "SEG-LO281-WAWLHR-2024-06-21-0725",
                "compartment": "ECONOMY",
                "bookingClass": "V",
                "statusCode": "HK",
                "quota": 9,
                "mileageAccrual": 500
              }
            ],
            "fareInfos": [
              {
                "fareType": "public",
                "fareClass": "VFLXN0",
                "pricedPassengerTypeCodes": [
                  "ADT"
                ],
                "travelerIds": [
                  "ADT-1"
                ],
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "prices": {
              "unitPrices": [
                {
                  "travelerIds": [
                    "ADT-1"
                  ],
                  "prices": [
                    {
                      "base": 65500,
                      "total": 76511,
                      "currencyCode": "PLN",
                      "totalTaxes": 11011,
                      "baseInMiles": 50278
                    }
                  ]
                }
              ],
              "totalPrices": [
                {
                  "base": 65500,
                  "total": 76511,
                  "currencyCode": "PLN",
                  "taxes": [
                    {
                      "value": 2172,
                      "currencyCode": "PLN",
                      "code": "YQYR"
                    }
                  ],
                  "totalTaxes": 11011,
                  "baseInMiles": 50278
                }
              ]
            },
            "services": [
              {
                "serviceCode": "FBA2-C0GOC1-0DCC2-0DDC3-0F8C4",
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "upgrade": {
              "targetAirBoundOfferId": "BC1-2-OFR-903140959299843-11-1-1",
              "targetCompartment": "BUSINESS",
              "priceDifference": [
                {
                  "currencyCode": "PLN",
                  "total": 48513,
                  "travelerId": "ADT-1"
                }
              ]
            }
          },
          {
            "airBoundOfferId": "BC1-2-OFR-903140959299843-8-1-1",
            "fareFamilyCode": "BIZSTD",
            "isCheapestOffer": false,
            "availabilityDetails": [
              {
                "segmentId": "SEG-LO281-WAWLHR-2024-06-21-0725",
                "compartment": "BUSINESS",
                "bookingClass": "Z",
                "statusCode": "HK",
                "quota": 9,
                "mileageAccrual": 1250
              }
            ],
            "fareInfos": [
              {
                "fareType": "public",
                "fareClass": "ZSFXB0",
                "pricedPassengerTypeCodes": [
                  "ADT"
                ],
                "travelerIds": [
                  "ADT-1"
                ],
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "prices": {
              "unitPrices": [
                {
                  "travelerIds": [
                    "ADT-1"
                  ],
                  "prices": [
                    {
                      "base": 87500,
                      "total": 105024,
                      "currencyCode": "PLN",
                      "totalTaxes": 17524,
                      "baseInMiles": 67165
                    }
                  ]
                }
              ],
              "totalPrices": [
                {
                  "base": 87500,
                  "total": 105024,
                  "currencyCode": "PLN",
                  "taxes": [
                    {
                      "value": 8685,
                      "currencyCode": "PLN",
                      "code": "YQYR"
                    }
                  ],
                  "totalTaxes": 17524,
                  "baseInMiles": 67165
                }
              ]
            },
            "services": [
              {
                "serviceCode": "FBA3-0FMC5",
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ]
          },
          {
            "airBoundOfferId": "BC1-2-OFR-903140959299843-11-1-1",
            "fareFamilyCode": "BIZFLX",
            "isCheapestOffer": false,
            "availabilityDetails": [
              {
                "segmentId": "SEG-LO281-WAWLHR-2024-06-21-0725",
                "compartment": "BUSINESS",
                "bookingClass": "Z",
                "statusCode": "HK",
                "quota": 9,
                "mileageAccrual": 1250
              }
            ],
            "fareInfos": [
              {
                "fareType": "public",
                "fareClass": "ZFFXB0",
                "pricedPassengerTypeCodes": [
                  "ADT"
                ],
                "travelerIds": [
                  "ADT-1"
                ],
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ],
            "prices": {
              "unitPrices": [
                {
                  "travelerIds": [
                    "ADT-1"
                  ],
                  "prices": [
                    {
                      "base": 107500,
                      "total": 125024,
                      "currencyCode": "PLN",
                      "totalTaxes": 17524,
                      "baseInMiles": 82517
                    }
                  ]
                }
              ],
              "totalPrices": [
                {
                  "base": 107500,
                  "total": 125024,
                  "currencyCode": "PLN",
                  "taxes": [
                    {
                      "value": 8685,
                      "currencyCode": "PLN",
                      "code": "YQYR"
                    }
                  ],
                  "totalTaxes": 17524,
                  "baseInMiles": 82517
                }
              ]
            },
            "services": [
              {
                "serviceCode": "FBA3-0FMC5",
                "segmentIds": [
                  "SEG-LO281-WAWLHR-2024-06-21-0725"
                ]
              }
            ]
          }
        ],
        "compartments": [
          {
            "compartmentName": "BUSINESS",
            "status": "AVAILABLE"
          },
          {
            "compartmentName": "ECONOMY",
            "status": "AVAILABLE"
          }
        ],
        "hasCheapestOffer": true,
        "isCodeShare": false
      }
    ],
    "showMilesAndCashSwitcher": true,
    "minMilesValue": 3000,
    "milesConversionRatio": 0.01302756645
  },
  "dictionaries": {
    "location": {
      "WAW": {
        "type": "airport",
        "airportName": "Warsaw",
        "cityCode": "WAW",
        "cityName": "Warsaw",
        "countryCode": "PL",
        "cityNameEn": "Warsaw",
        "countryEn": "Poland"
      },
      "LON": {
        "type": "city",
        "airportName": "London - all airports",
        "cityCode": "LON",
        "cityName": "London",
        "countryCode": "GB",
        "cityNameEn": "London",
        "countryEn": "Great Britain"
      },
      "LHR": {
        "type": "airport",
        "airportName": "London - Heathrow",
        "cityCode": "LON",
        "cityName": "London",
        "countryCode": "GB",
        "cityNameEn": "London",
        "countryEn": "Great Britain"
      }
    },
    "country": {
      "GB": "Great Britain",
      "PL": "Poland"
    },
    "airline": {
      "LO": "LOT POLISH AIRLINES"
    },
    "aircraft": {
      "7M8": "BOEING 737 MAX 8"
    },
    "segment": {
      "SEG-LO281-WAWLHR-2024-06-21-0725": {
        "marketingAirlineCode": "LO",
        "operatingAirlineCode": "LO",
        "marketingFlightNumber": "281",
        "departure": {
          "locationCode": "WAW",
          "dateTime": "2024-06-21T07:25:00+02:00"
        },
        "arrival": {
          "locationCode": "LHR",
          "dateTime": "2024-06-21T09:20:00+01:00",
          "terminal": "2"
        },
        "aircraftCode": "7M8",
        "duration": 10500,
        "secureFlightIndicator": false,
        "isOpenSegment": false,
        "features": [
          {
            "featureId": "PRESS",
            "title": "E-press",
            "applicability": "included",
            "featureGroupId": "Info"
          },
          {
            "featureId": "MEA1",
            "title": "1 x snack, 1 x drink",
            "applicability": "included",
            "featureGroupId": "Info"
          },
          {
            "featureId": "EPRS",
            "title": "Onboard entertainment",
            "applicability": "included",
            "featureGroupId": "Info"
          }
        ]
      }
    },
    "currency": {
      "PLN": {
        "name": "POLISH ZLOTY",
        "decimalPlaces": 2
      }
    },
    "service": {
      "FBA2-C0GOC1-0DCC2-0DDC3-0F8C4": {
        "marketingAirlineCode": "LO",
        "serviceType": "freeCheckedBaggage",
        "baggagePolicyDescriptions": [
          {
            "type": "piece",
            "quantity": 1,
            "baggageCharacteristics": [
              {
                "description": "PREPAID TO 23KG OR EXC DIM",
                "policyDetails": [
                  {
                    "type": "weight",
                    "qualifier": "upTo",
                    "value": "23",
                    "unit": "kilogram"
                  },
                  {
                    "type": "weight",
                    "qualifier": "upTo",
                    "value": "50",
                    "unit": "pound"
                  },
                  {
                    "type": "size",
                    "qualifier": "upTo",
                    "value": "158",
                    "unit": "centimeter"
                  },
                  {
                    "type": "size",
                    "qualifier": "upTo",
                    "value": "62",
                    "unit": "inch"
                  }
                ]
              },
              {
                "description": "GOLF EQUIPMENT"
              },
              {
                "description": "SKI EQUIPMENT"
              },
              {
                "description": "SPORTING EQUIPMENT"
              }
            ]
          }
        ]
      },
      "FBA3-0FMC5": {
        "marketingAirlineCode": "LO",
        "serviceType": "freeCheckedBaggage",
        "baggagePolicyDescriptions": [
          {
            "type": "piece",
            "quantity": 2,
            "baggageCharacteristics": [
              {
                "description": "UPTO70LB 32KG AND62LI 158LCM",
                "policyDetails": [
                  {
                    "type": "weight",
                    "qualifier": "upTo",
                    "value": "32",
                    "unit": "kilogram"
                  },
                  {
                    "type": "weight",
                    "qualifier": "upTo",
                    "value": "70",
                    "unit": "pound"
                  },
                  {
                    "type": "size",
                    "qualifier": "upTo",
                    "value": "158",
                    "unit": "centimeter"
                  },
                  {
                    "type": "size",
                    "qualifier": "upTo",
                    "value": "62",
                    "unit": "inch"
                  }
                ]
              }
            ]
          }
        ]
      },
      "FBA1": {
        "serviceType": "freeCheckedBaggage",
        "baggagePolicyDescriptions": [
          {
            "type": "piece",
            "quantity": 0
          }
        ]
      }
    }
  }
}
""".trimIndent()

@Language("JSON")
val lotSearchTripsBadRequestResponseRaw = """
{
  "errors": [
    {
      "code": "ERR-0001",
      "message": "Invalid request"
    }
  ],
  "warnings": [],
  "ibeFlowId": "iZIYCRUZmm",
  "data": {
    "airBoundFlights": []
  },
  "dictionaries": {}
}
""".trimIndent()