package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaElementAttribute

@SchemaDsl
interface SchemaElementBuilderScope {
    val name: String
    var docs: String?

    operator fun SchemaElementAttribute.unaryPlus() {}
}