package org.twowls.poc.seabaas.schema.script

import org.twowls.poc.seabaas.schema.dsl.SchemaContainerBuilderScope
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.jvmTarget

@KotlinScript(
    fileExtension = "schema.kts",
    displayName = "SeaBaasSchema",
    compilationConfiguration = SchemaScript.CompilationConfig::class
)
abstract class SchemaScript {
    object CompilationConfig : ScriptCompilationConfiguration({
        jvm {
            dependenciesFromCurrentContext(wholeClasspath = true)
            jvmTarget("17")
        }
        ide {
            acceptedLocations(ScriptAcceptedLocation.Everywhere)
        }
        defaultImports("org.twowls.poc.seabaas.schema.dsl.*")
        implicitReceivers(SchemaContainerBuilderScope::class)
    }) {
        private fun readResolve(): Any = CompilationConfig
    }
}