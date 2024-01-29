package org.twowls.poc.seabaas.schema.dsl

object TestSchemas {
    val blog by lazy {
        createSchemaRegistry {
            schema("user") {
                field("email")
            }

            schema("post") {
                field("title")
                field("content")
                relationship("author", relatedSchemaName = "user")
                relationship("comments", relatedSchemaName = "comment") {
                    //+HasMany
                }
            }

            schema("comment") {
                field("content")
                relationship("commenter", relatedSchemaName = "user")
            }
        }
    }

    val ticket by lazy {
        createSchemaRegistry {
            schema("person") {
                field("firstName")
                field("lastName")
                field("gender")
            }

            schema("country") {
                //+NaturalKey("isoCode")
                field("isoCode")
            }

            schema("airport") {
                field("iataCode")
                field("locationCity")
                relationship("locationCountry", relatedSchemaName = "country")
            }

            schema("ticket") {
                relationship("departureAirport", relatedSchemaName = "airport")

                schema("flightSegment") {
                    field("flightNumber")
                    field("departureTime")
                    field("arrivalTime")
                    relationship("arrivalAirport", relatedSchemaName = "airport")
                }

                embedment("segment", embeddedSchemaName = "flightSegment") {
                    docs = "Segments of this flight (up to 5)"
                    //+Required +HasMany(5)
                }

                relationship("passenger", relatedSchemaName = "person") {
                    docs = "Passengers of this flight (up to 3)"
                }
            }
        }
    }
}