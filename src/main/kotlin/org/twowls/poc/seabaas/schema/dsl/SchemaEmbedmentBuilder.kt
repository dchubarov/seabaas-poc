package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaEmbedmentElement

@SchemaDsl
class SchemaEmbedmentBuilder(
    name: String,
    val embeddedSchemaName: String
) : AbstractSchemaElementBuilder<SchemaEmbedmentElement>(name) {
    override fun build(): SchemaEmbedmentElement {
        TODO("Not yet implemented")
    }
}