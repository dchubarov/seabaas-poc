package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaEmbedmentElement

class SchemaEmbedmentBuilder(
    override val name: String,
    val embeddedSchemaName: String
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaEmbedmentElement>() {
    override var docs: String? = null

    override fun build(): SchemaEmbedmentElement {
        TODO("Not yet implemented")
    }
}