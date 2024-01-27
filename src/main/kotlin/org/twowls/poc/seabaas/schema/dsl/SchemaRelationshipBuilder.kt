package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaRelationshipElement

class SchemaRelationshipBuilder(
    override val name: String,
    private val relatedSchemaName: String
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaRelationshipElement>() {
    override var docs: String? = null

    override fun collectDependencies(): Set<String> =
        setOf(relatedSchemaName)

    override fun build(): SchemaRelationshipElement {
        TODO("Not yet implemented")
    }
}