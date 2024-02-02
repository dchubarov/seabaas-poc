
schema("person") {
    field("firstName")
    field("lastName")
}

schema("airport") {
    +PrimaryKey("iataCode")
    field("iataCode") {
        docs = "Airport's IATA code (3-letter)"
    }
}

schema("ticket") {
    relationship("departureAirport")
    field("departureDate")
    schema("flightSegment") {
        field("flightNumber")
        field("arrivalDate")
        relationship("arrivalAirport")
    }
    embedment("segment", embeddedSchema = "flightSegment") {
        +HasMany(1..5)
    }
    relationship("passenger", relatedSchema = "person") {
        +HasMany(1..3)
    }
}