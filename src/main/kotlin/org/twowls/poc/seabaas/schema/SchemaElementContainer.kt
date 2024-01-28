package org.twowls.poc.seabaas.schema

import java.util.*

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

    fun toStringHierarchy(
        indent: String = "\t",
        delimiter: String = "\n",
        open: String = "",
        close: String = ""
    ): String {
        val sb = StringBuilder(toString()).append(open).append(delimiter)
        val stack = LinkedList<Iterator<SchemaElement>>()
        stack.push(iterator())
        topIterator@ do {
            val iter = stack.peek()
            while (iter.hasNext()) {
                val element = iter.next()
                sb.append(indent.repeat(stack.size)).append(element.toString())
                if (element is SchemaElementContainer<*>) {
                    stack.push(element.iterator())
                    sb.append(open).append(delimiter)
                    continue@topIterator
                } else
                    sb.append(delimiter)
            }
            stack.pop()
            if (close.isNotEmpty()) {
                sb.append(indent.repeat(stack.size)).append(close)
                if (stack.isNotEmpty()) sb.append(delimiter)
            }
        } while (stack.isNotEmpty())
        return sb.trimEnd().toString()
    }
}