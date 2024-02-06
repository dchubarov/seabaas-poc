package org.twowls.poc.seabaas.schema

sealed class SchemaType<T> {
    data object Text : SchemaType<String>()
}