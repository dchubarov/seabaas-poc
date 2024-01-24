package org.twowls.poc.seabaas

import io.github.oshai.kotlinlogging.KotlinLogging
import org.twowls.poc.seabaas.catalog.scanCatalog
import kotlin.io.path.Path

private val logger = KotlinLogging.logger { }

fun main(args: Array<String>) {
    logger.info { "Entrypoint invoked with args: ${args.contentToString()}" }
    scanCatalog(Path("/Users/dchubarov/Documents"), maxDepth = 2)
}