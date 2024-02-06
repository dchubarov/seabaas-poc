package org.twowls.poc.seabaas.schema

sealed class SchemaElementAttribute {

    data object Required : SchemaElementAttribute()
}