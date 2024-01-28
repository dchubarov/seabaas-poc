package org.twowls.poc.seabaas.schema

/**
 * Represents a relationship between compound elements.
 *
 * @author dime
 */
class SchemaRelationshipElement(
    override val name: String,
    override val docs: String?,
    private val relatedSchema: SchemaCompoundElement
) : SchemaElement {
    override fun toString(): String {
        return "${this::class.simpleName} {name=$name, relatedSchema=$relatedSchema}"
    }
}