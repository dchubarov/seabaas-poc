package org.twowls.poc.seabaas

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger { }

fun main(args: Array<String>) {
    logger.info { "Entrypoint invoked with args: ${args.contentToString()}" }
}