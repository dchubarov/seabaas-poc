package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaRelationshipElement

@SchemaDsl
class SchemaRelationshipBuilder(
    name: String,
    relatedSchemaName: String
) : AbstractSchemaElementBuilder<SchemaRelationshipElement>(name) {

    override fun build(): SchemaRelationshipElement {
        TODO("Not yet implemented")
    }
}