package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaFieldElement
import org.twowls.poc.seabaas.schema.SchemaType

class SchemaFieldBuilder(
    override val name: String,
    private val datatype: SchemaType<*>
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaFieldElement>() {
    override var docs: String? = null

    override fun build(): SchemaFieldElement =
        SchemaFieldElement(name, docs, datatype)
}