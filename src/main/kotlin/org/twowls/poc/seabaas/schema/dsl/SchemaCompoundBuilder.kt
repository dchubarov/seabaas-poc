package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement

class SchemaCompoundBuilder(
    override val name: String
) : SchemaElementBuilderScope, SchemaCompoundBuilderScope,
    AbstractSchemaContainerBuilder<SchemaCompoundElement>() {

    override var docs: String? = null

    fun registerField(builder: SchemaFieldBuilder): SchemaCompoundBuilder {
        registerChildBuilder(builder)
        return this
    }

    fun registerEmbedment(builder: SchemaEmbedmentBuilder): SchemaCompoundBuilder {
        registerChildBuilder(builder)
        return this
    }

    fun registerRelationship(builder: SchemaRelationshipBuilder): SchemaCompoundBuilder {
        registerChildBuilder(builder)
        return this
    }

    override fun build(): SchemaCompoundElement =
        SchemaCompoundElement(name, docs, buildChildren())
}