package org.twowls.poc.seabaas.schema.base

/**
 * Represent a compound schema element.
 *
 * @author dime
 */
class SchemaCompoundElement(
    override val name: String,
    override val docs: String?,
    elements: Iterable<SchemaElement>
) : SchemaElement, SchemaElementContainer<SchemaElement>(elements)