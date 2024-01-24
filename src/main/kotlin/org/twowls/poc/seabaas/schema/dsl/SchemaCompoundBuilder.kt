package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.base.SchemaCompoundElement
import org.twowls.poc.seabaas.schema.base.SchemaElement

@SchemaDsl
class SchemaCompoundBuilder(name: String) : AbstractSchemaElementBuilder<SchemaCompoundElement>(name) {
    private val elements = mutableListOf<SchemaElement>()

    @SchemaDsl
    fun schema(name: String, block: SchemaCompoundBuilder.() -> Unit = {}) {
        elements += SchemaCompoundBuilder(name).apply(block).build() as SchemaElement
    }

    @SchemaDsl
    fun field(name: String, block: SchemaFieldBuilder.() -> Unit = {}) {
        elements += SchemaFieldBuilder(name).apply(block).build()
    }

    @SchemaDsl
    fun embedment(name: String, block: SchemaEmbedmentBuilder.() -> Unit = {}) {
        elements += SchemaEmbedmentBuilder(name).apply(block).build()
    }

    @SchemaDsl
    fun relationship(name: String, block: SchemaRelationshipBuilder.() -> Unit = {}) {
        elements += SchemaRelationshipBuilder(name).apply(block).build()
    }

    override fun build(): SchemaCompoundElement =
        SchemaCompoundElement(name, docs, elements)
}

@SchemaDsl
fun schema(name: String, block: SchemaCompoundBuilder.() -> Unit) =
    SchemaCompoundBuilder(name).apply(block).build()