package org.twowls.poc.seabaas.schema.script

import io.github.oshai.kotlinlogging.KotlinLogging
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeTypeOf
import org.twowls.poc.seabaas.schema.dsl.SchemaRegistryBuilder
import java.io.FileNotFoundException
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.api.implicitReceivers
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate
import kotlin.script.experimental.jvmhost.createJvmEvaluationConfigurationFromTemplate

private val logger = KotlinLogging.logger { }

class SchemaScriptTests : FunSpec({
    test("should load and evaluate test script") {
        val resourceAsStream = SchemaScriptTests::class.java.classLoader.getResourceAsStream("test.schema.kts_")
        val script = resourceAsStream?.bufferedReader()?.use { it.readText().toScriptSource("test.kts") }
            ?: throw FileNotFoundException()

        val rootBuilder = SchemaRegistryBuilder()

        val compilationConfig = createJvmCompilationConfigurationFromTemplate<SchemaScript>()
        val evaluationConfig = createJvmEvaluationConfigurationFromTemplate<SchemaScript> {
            implicitReceivers(rootBuilder)
        }

        val result = BasicJvmScriptingHost().eval(
            script,
            compilationConfig,
            evaluationConfig
        )

        logger.info { "Script compilation and evaluation result:" }
        result.reports.forEach {
            if (logger.isDebugEnabled() || it.severity > ScriptDiagnostic.Severity.DEBUG) {
                logger.info {
                    "\t${it.message}" + if (it.location == null) "" else "at ${it.location}" +
                            if (it.exception == null) "" else ": ${it.exception}"
                }
            }
        }

        result.shouldBeTypeOf<ResultWithDiagnostics.Success<*>>()

        val registry = rootBuilder.build()
        logger.info { "Script produced definitions: ${registry.toStringHierarchy()}" }
    }
})