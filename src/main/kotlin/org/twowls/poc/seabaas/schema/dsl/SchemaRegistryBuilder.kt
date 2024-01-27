package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement
import org.twowls.poc.seabaas.schema.SchemaRegistry

class SchemaRegistryBuilder : SchemaContainerBuilderScope, AbstractSchemaContainerBuilder<SchemaRegistry>() {
    override val name: String = ""
    override fun build(): SchemaRegistry =
        SchemaRegistry(buildChildren().map { it as SchemaCompoundElement })
}

inline fun createSchemaRegistry(
    block: SchemaContainerBuilderScope.() -> Unit
): SchemaRegistry = SchemaRegistryBuilder().apply(block).build()