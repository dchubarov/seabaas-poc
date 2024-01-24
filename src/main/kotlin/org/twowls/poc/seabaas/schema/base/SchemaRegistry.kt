package org.twowls.poc.seabaas.schema.base

/**
 * Schema registry contains top-level compound elements.
 *
 * @author dime
 */
class SchemaRegistry(
    elements: Iterable<SchemaCompoundElement>
) : SchemaElementContainer<SchemaCompoundElement>(elements) {

    companion object {
        fun of(vararg schemas: SchemaCompoundElement) =
            SchemaRegistry(schemas.toList())
    }
}