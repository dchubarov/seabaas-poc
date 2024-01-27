package org.twowls.poc.seabaas.schema.dsl

@SchemaDsl
interface SchemaContainerBuilderScope

inline fun SchemaContainerBuilderScope.schema(
    name: String,
    block: SchemaCompoundBuilderScope.() -> Unit
) {
    (this as AbstractSchemaContainerBuilder<*>)
        .registerSchema(SchemaCompoundBuilder(name).apply(block))
}