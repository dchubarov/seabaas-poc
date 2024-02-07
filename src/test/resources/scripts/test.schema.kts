package scripts

schema("person") {
    docs = "Person data"
    embedment("name", embeddedSchemaName = "personalName") {
        +Cardinality.ZeroOrMore // multiple cardinalities causes a warning, last should survive
        +Cardinality.ZeroOrOnce
        +Cardinality.OnceOrMore

        +Cardinality.Once
    }
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