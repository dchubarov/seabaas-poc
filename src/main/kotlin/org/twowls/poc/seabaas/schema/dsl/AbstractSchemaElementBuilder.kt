package org.twowls.poc.seabaas.schema.dsl

abstract class AbstractSchemaElementBuilder<E> {
    abstract val name: String

    internal open fun collectDependencies(): Set<String> =
        emptySet()

    abstract fun build(): E
}