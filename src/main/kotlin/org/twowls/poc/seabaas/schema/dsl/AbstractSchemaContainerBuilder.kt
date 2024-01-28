package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement
import org.twowls.poc.seabaas.schema.SchemaElement
import org.twowls.poc.seabaas.schema.SchemaElementContainer

abstract class AbstractSchemaContainerBuilder<E : SchemaElementContainer<*>> : AbstractSchemaElementBuilder<E>() {
    private val childBuilders = mutableMapOf<String, AbstractSchemaElementBuilder<SchemaElement>>()
    private val resolvedDeps = mutableMapOf<String, SchemaCompoundElement>()

    fun registerSchema(builder: SchemaCompoundBuilder): AbstractSchemaContainerBuilder<E> {
        registerChildBuilder(builder)
        return this
    }

    override fun collectDependencies(): Set<String> =
        childBuilders.values
            .flatMap { it.collectDependencies() }
            .filterNot(childBuilders::containsKey)
            .toSet()

    override fun resolveDependency(schema: SchemaCompoundElement) {
        resolvedDeps += schema.name to schema
    }

    protected fun registerChildBuilder(builder: AbstractSchemaElementBuilder<SchemaElement>) {
        childBuilders += builder.name to builder
    }

    protected fun buildChildren(): List<SchemaElement> {
        val deps = mutableMapOf<String, MutableSet<String>>()
        for (builder in childBuilders.values) {
            val childDeps = builder.collectDependencies().toMutableSet()
            resolvedDeps.forEach {
                if (childDeps.contains(it.key)) {
                    builder.resolveDependency(it.value)
                    childDeps.remove(it.key)
                }
            }
            deps += builder.name to childDeps
        }

        val elements = mutableListOf<SchemaElement>()
        while (deps.isNotEmpty()) {
            val (name, _) = deps.entries.first { it.value.isEmpty() }
            val element = childBuilders[name]!!.build()
            deps -= name

            if (element is SchemaCompoundElement) {
                deps.forEach {
                    if (it.value.contains(name)) {
                        childBuilders[it.key]!!.resolveDependency(element)
                        it.value -= name
                    }
                }
            }

            elements += element
        }

        return elements.toList()
    }
}