package scripts

schema("person") {
    docs = "Person data"
    embedment("name", embeddedSchemaName = "personalName")
    field("age")
}

schema("personalName") {
    field("givenName", Text) {
        +Required
    }
    field("familyName")
    field("middleName") {
        docs = "Middle name(s), initial, or a patronymic name"
    }
}