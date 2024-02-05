package scripts

schema("person") {
    docs = "Person data"
    embedment("name", embeddedSchemaName = "personalName")
    field("age")
}

schema("personalName") {
    field("givenName")
    field("familyName")
    field("middleName") {
        docs = "Middle name(s), initial, or a patronym"
    }
}