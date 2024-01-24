package org.twowls.poc.seabaas.schema

/**
 * Represents a container of zero or more schema elements.
 *
 * @author dime
 */
sealed class SchemaElementContainer<out E : SchemaElement>(
    elements: Iterable<E>
) : Iterable<E> {
    private val namedElements: Map<String, E> = elements.associateBy { it.name }

    operator fun get(name: String): E? =
        namedElements[name]

    override fun iterator(): Iterator<E> =
        namedElements.values.iterator()
}