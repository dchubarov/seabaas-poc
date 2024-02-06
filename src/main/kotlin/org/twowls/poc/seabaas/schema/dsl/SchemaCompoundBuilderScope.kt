package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaType

interface SchemaCompoundBuilderScope : SchemaContainerBuilderScope, SchemaElementBuilderScope

inline fun SchemaCompoundBuilderScope.field(
    name: String,
    datatype: SchemaType<*> = SchemaType.Text,
    block: SchemaElementBuilderScope.() -> Unit = {}
) {
    (this as SchemaCompoundBuilder)
        .registerField(SchemaFieldBuilder(name, datatype).apply(block))
}

inline fun SchemaCompoundBuilderScope.embedment(
    name: String,
    embeddedSchemaName: String,
    block: SchemaElementBuilderScope.() -> Unit = {}
) {
    (this as SchemaCompoundBuilder)
        .registerEmbedment(SchemaEmbedmentBuilder(name, embeddedSchemaName).apply(block))
}

inline fun SchemaCompoundBuilderScope.relationship(
    name: String,
    relatedSchemaName: String,
    block: SchemaElementBuilderScope.() -> Unit = {}
) {
    (this as SchemaCompoundBuilder)
        .registerRelationship(SchemaRelationshipBuilder(name, relatedSchemaName).apply(block))
}