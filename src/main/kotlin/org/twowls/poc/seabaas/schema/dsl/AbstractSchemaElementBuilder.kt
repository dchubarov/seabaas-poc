package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.base.SchemaElement

@SchemaDsl
sealed class AbstractSchemaElementBuilder<E : SchemaElement>(val name: String) {
    var docs: String? = null

    abstract fun build(): E
}