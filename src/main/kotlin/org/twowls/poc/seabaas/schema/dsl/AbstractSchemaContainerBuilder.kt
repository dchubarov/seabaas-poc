package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaElement
import org.twowls.poc.seabaas.schema.SchemaElementContainer

abstract class AbstractSchemaContainerBuilder<E : SchemaElementContainer<*>> : AbstractSchemaElementBuilder<E>() {
    private val childBuilders = mutableMapOf<String, AbstractSchemaElementBuilder<*>>()

    fun registerSchema(builder: SchemaCompoundBuilder): AbstractSchemaContainerBuilder<E> {
        registerChildBuilder(builder)
        return this
    }

    override fun collectDependencies(): Set<String> =
        childBuilders.values
            .flatMap { it.collectDependencies() }
            .toSet()

    protected fun registerChildBuilder(builder: AbstractSchemaElementBuilder<*>) {
        childBuilders += builder.name to builder
    }

    protected fun buildChildren(): List<SchemaElement> {
        for (builder in childBuilders.values) {
            println("${builder.name} deps=${builder.collectDependencies()}")
        }
        return emptyList()
    }
}