package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaElement

@SchemaDsl
abstract class AbstractSchemaElementBuilder<E : SchemaElement>(val name: String) {
    var docs: String? = null

    abstract fun build(): E
}