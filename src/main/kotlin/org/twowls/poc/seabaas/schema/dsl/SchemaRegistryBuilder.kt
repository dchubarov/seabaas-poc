package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaRegistry

class SchemaRegistryBuilder : SchemaContainerBuilderScope, AbstractSchemaContainerBuilder<SchemaRegistry>() {
    override fun build(): SchemaRegistry =
        TODO()
}

inline fun createSchemaRegistry(
    block: SchemaContainerBuilderScope.() -> Unit
): SchemaRegistry = SchemaRegistryBuilder().apply(block).build()