package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement

abstract class AbstractSchemaElementBuilder<out E> {
    abstract val name: String

    abstract fun build(): E

    internal open fun collectDependencies(): Set<String> =
        emptySet()

    internal open fun resolveDependency(schema: SchemaCompoundElement) {}
}