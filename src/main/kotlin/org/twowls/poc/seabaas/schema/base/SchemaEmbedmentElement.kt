package org.twowls.poc.seabaas.schema.base

/**
 * Embedment is a compound element contained inside owner element.
 *
 * @author dime
 */
class SchemaEmbedmentElement(
    override val name: String,
    override val docs: String?
) : SchemaElement