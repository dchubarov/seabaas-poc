package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaRelationshipElement

class SchemaRelationshipBuilder(
    override val name: String,
    val relatedSchemaName: String
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaRelationshipElement>() {
    override var docs: String? = null

    override fun build(): SchemaRelationshipElement {
        TODO("Not yet implemented")
    }
}