package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaElementAttribute.Cardinality
import org.twowls.poc.seabaas.schema.SchemaElementAttribute.Required

object TestSchemas {
    val blog by lazy {
        createSchemaRegistry {
            schema("user") {
                field("email") {
                    +Required
                }
            }

            schema("post") {
                field("title")
                field("content")
                relationship("author", relatedSchemaName = "user")
                relationship("comments", relatedSchemaName = "comment") {
                    +Cardinality.ZeroOrMore
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
                relationship("locationCountry", relatedSchemaName = "country") {
                    +Cardinality.Once
                }
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
                    +Cardinality.Range(1..5)
                }

                relationship("passenger", relatedSchemaName = "person") {
                    docs = "Passengers of this flight (up to 3)"
                    +Cardinality.Range(1..3)
                }
            }
        }
    }
}