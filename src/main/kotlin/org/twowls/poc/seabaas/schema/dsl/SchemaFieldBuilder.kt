package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaFieldElement

class SchemaFieldBuilder(
    override val name: String
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaFieldElement>() {
    override var docs: String? = null

    override fun build(): SchemaFieldElement =
        SchemaFieldElement(name, docs)
}