package org.twowls.poc.seabaas.schema.base

/**
 * Top level abstraction of a schema element.
 *
 * @author dime
 */
interface SchemaElement {
    /** Uniquely identifies the element within its scope */
    val name: String

    /** Optional documentation */
    val docs: String?
}