package org.twowls.poc.seabaas.schema.dsl

import org.twowls.poc.seabaas.schema.SchemaCompoundElement
import org.twowls.poc.seabaas.schema.SchemaRelationshipElement

class SchemaRelationshipBuilder(
    override val name: String,
    private val relatedSchemaName: String
) : SchemaElementBuilderScope, AbstractSchemaElementBuilder<SchemaRelationshipElement>() {
    override var docs: String? = null
    private var relatedSchema: SchemaCompoundElement? = null

    override fun build(): SchemaRelationshipElement {
        return relatedSchema?.let { SchemaRelationshipElement(name, docs, it) }
            ?: throw IllegalStateException("Unresolved dependency $name->$relatedSchemaName")
    }

    override fun collectDependencies(): Set<String> =
        setOf(relatedSchemaName)

    override fun resolveDependency(schema: SchemaCompoundElement) {
        if (schema.name == relatedSchemaName)
            relatedSchema = schema
    }
}