package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement

@SchemaDsl
class SchemaCompoundBuilder(name: String) : AbstractSchemaElementBuilder<SchemaCompoundElement>(name) {

    fun addSchema(builder: SchemaCompoundBuilder): SchemaCompoundBuilder {
        return this
    }

    fun addField(builder: SchemaFieldBuilder): SchemaCompoundBuilder {
        return this
    }

    fun addEmbedment(builder: SchemaEmbedmentBuilder): SchemaCompoundBuilder {
        return this
    }

    fun addRelationship(builder: SchemaRelationshipBuilder): SchemaCompoundBuilder {
        return this
    }

    override fun build(): SchemaCompoundElement {
        TODO("Not yet implemented")
    }
}

inline fun SchemaCompoundBuilder.schema(
    name: String,
    block: SchemaCompoundBuilder.() -> Unit = {}
) = addSchema(SchemaCompoundBuilder(name).apply(block))

inline fun SchemaCompoundBuilder.field(
    name: String,
    block: SchemaFieldBuilder.() -> Unit = {}
) = addField(SchemaFieldBuilder(name).apply(block))

inline fun SchemaCompoundBuilder.embedment(
    name: String,
    embeddedSchemaName: String,
    block: SchemaEmbedmentBuilder.() -> Unit = {}
) = addEmbedment(SchemaEmbedmentBuilder(name, embeddedSchemaName).apply(block))

inline fun SchemaCompoundBuilder.relationship(
    name: String,
    relatedSchemaName: String,
    block: SchemaRelationshipBuilder.() -> Unit = {}
) = addRelationship(SchemaRelationshipBuilder(name, relatedSchemaName).apply(block))