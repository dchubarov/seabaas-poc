package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaElementContainer

abstract class AbstractSchemaContainerBuilder<E : SchemaElementContainer<*>> : AbstractSchemaElementBuilder<E>() {
    fun registerSchema(builder: SchemaCompoundBuilder): AbstractSchemaContainerBuilder<E> {
        return this
    }
}