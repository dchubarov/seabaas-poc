package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaRegistry

@SchemaDsl
class SchemaRegistryBuilder {

    fun addSchema(builder: SchemaCompoundBuilder): SchemaRegistryBuilder {
        return this
    }

    fun build(): SchemaRegistry =
        TODO()
}

inline fun SchemaRegistryBuilder.schema(
    name: String,
    block: SchemaCompoundBuilder.() -> Unit
) = addSchema(SchemaCompoundBuilder(name).apply(block))

inline fun createSchemaRegistry(
    block: SchemaRegistryBuilder.() -> Unit
) = SchemaRegistryBuilder().apply(block).build()