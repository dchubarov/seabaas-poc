package org.twowls.poc.seabaas.schema

/**
 * Schema registry contains top-level compound elements.
 *
 * @author dime
 */
class SchemaRegistry(
    elements: Iterable<SchemaCompoundElement>
) : SchemaElementContainer<SchemaCompoundElement>(elements)