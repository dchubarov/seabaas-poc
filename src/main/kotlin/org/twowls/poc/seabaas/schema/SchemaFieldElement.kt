package org.twowls.poc.seabaas.schema

/**
 * Represents an element containing a data value.
 *
 * @author dime
 */
class SchemaFieldElement(
    override val name: String,
    override val docs: String?
) : SchemaElement {
    override fun toString(): String {
        return "${this::class.simpleName} {name=$name}"
    }
}