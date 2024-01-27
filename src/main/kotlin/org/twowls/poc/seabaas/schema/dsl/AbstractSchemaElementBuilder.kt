package org.twowls.poc.seabaas.schema.dsl

abstract class AbstractSchemaElementBuilder<E> {
    abstract fun build(): E
}