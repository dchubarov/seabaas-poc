package org.twowls.poc.seabaas.schema.script

import org.twowls.poc.seabaas.schema.dsl.SchemaContainerBuilderScope
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.api.implicitReceivers
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.jvmTarget

@KotlinScript(
    fileExtension = "schema.kts",
    compilationConfiguration = SchemaScriptCompilationConfigurationTemplate::class,
)
abstract class SchemaScript

object SchemaScriptCompilationConfigurationTemplate : ScriptCompilationConfiguration({
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
        jvmTarget("20")
    }
    defaultImports("org.twowls.poc.seabaas.schema.dsl.*")
    implicitReceivers(SchemaContainerBuilderScope::class)
}) {
    private fun readResolve(): Any =
        SchemaScriptCompilationConfigurationTemplate
}