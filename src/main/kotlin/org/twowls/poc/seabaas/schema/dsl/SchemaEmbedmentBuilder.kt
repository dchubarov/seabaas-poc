package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.base.SchemaEmbedmentElement

@SchemaDsl
class SchemaEmbedmentBuilder(name: String) : AbstractSchemaElementBuilder<SchemaEmbedmentElement>(name) {
    override fun build(): SchemaEmbedmentElement =
        SchemaEmbedmentElement(name, docs)
}