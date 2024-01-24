package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaFieldElement

@SchemaDsl
class SchemaFieldBuilder(name: String) : AbstractSchemaElementBuilder<SchemaFieldElement>(name) {
    override fun build(): SchemaFieldElement =
        SchemaFieldElement(name, docs)
}