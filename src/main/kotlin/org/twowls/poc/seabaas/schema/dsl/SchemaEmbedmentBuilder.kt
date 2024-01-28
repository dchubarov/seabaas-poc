package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement
import org.twowls.poc.seabaas.schema.SchemaEmbedmentElement

class SchemaEmbedmentBuilder(
    override val name: String,
    private val embeddedSchemaName: String
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaEmbedmentElement>() {
    override var docs: String? = null
    private var embeddedSchema: SchemaCompoundElement? = null

    override fun build(): SchemaEmbedmentElement {
        return embeddedSchema?.let { SchemaEmbedmentElement(name, docs, it) }
            ?: throw IllegalStateException("Unresolved dependency $name->$embeddedSchemaName")
    }

    override fun collectDependencies(): Set<String> =
        setOf(embeddedSchemaName)

    override fun resolveDependency(schema: SchemaCompoundElement) {
        if (schema.name == embeddedSchemaName)
            embeddedSchema = schema
    }
}