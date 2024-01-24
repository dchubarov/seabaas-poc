package org.twowls.poc.seabaas.schema.base

/**
 * Represents a relationship between compound elements.
 *
 * @author dime
 */
class SchemaRelationshipElement(
    override val name: String,
    override val docs: String?
) : SchemaElement