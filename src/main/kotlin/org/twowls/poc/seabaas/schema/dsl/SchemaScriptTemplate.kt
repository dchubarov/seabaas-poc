package org.twowls.poc.seabaas.schema.dsl

import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.jvmTarget

@KotlinScript(
    fileExtension = "schema.kts",
    displayName = "SeaBaaS Schema",
    compilationConfiguration = SchemaScriptTemplate.CompilationConfig::class
)
abstract class SchemaScriptTemplate {
    object CompilationConfig : ScriptCompilationConfiguration({
        jvm {
            dependenciesFromCurrentContext(wholeClasspath = true)
            jvmTarget("17")
        }
        ide {
            acceptedLocations(ScriptAcceptedLocation.Everywhere)
        }
        defaultImports(
            "org.twowls.poc.seabaas.schema.dsl.*",
            "org.twowls.poc.seabaas.schema.SchemaType.*",
            "org.twowls.poc.seabaas.schema.SchemaElementAttribute.*"
        )
        implicitReceivers(SchemaContainerBuilderScope::class)
    }) {
        private fun readResolve(): Any = CompilationConfig
    }
}