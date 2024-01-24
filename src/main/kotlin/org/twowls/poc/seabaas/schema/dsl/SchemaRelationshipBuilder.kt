package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.base.SchemaRelationshipElement

@SchemaDsl
class SchemaRelationshipBuilder(name: String) : AbstractSchemaElementBuilder<SchemaRelationshipElement>(name) {
    override fun build(): SchemaRelationshipElement =
        SchemaRelationshipElement(name, docs)
}