package org.twowls.poc.seabaas.schema.dsl

@SchemaDsl
interface SchemaElementBuilderScope {
    val name: String
    var docs: String?
}