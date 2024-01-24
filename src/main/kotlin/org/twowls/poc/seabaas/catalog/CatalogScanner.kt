package org.twowls.poc.seabaas.catalog

import io.github.oshai.kotlinlogging.KotlinLogging
import java.nio.file.LinkOption
import java.nio.file.Path
import java.util.*
import kotlin.io.path.isDirectory
import kotlin.io.path.isRegularFile
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name

// private val yamlMapper = ObjectMapper(YAMLFactory())
// don't forget yamlMapper.findAndRegisterModules()

private val logger = KotlinLogging.logger { }

fun scanCatalog(rootDir: Path, maxDepth: Int = 1) {
    check(rootDir.isDirectory()) { "Schema catalog root path is not a directory: $rootDir" }
    logger.info { "Scanning schema catalog ${rootDir.toAbsolutePath().normalize()}..." }
    logger.debug { "\tmaximum depth $maxDepth" }

    val subDirectories = LinkedList<Pair<Path, Int>>()
        .apply { push(rootDir to 0) }

    do {
        val dirAndDepth = subDirectories.poll()
        for (dirEntry in dirAndDepth.first.listDirectoryEntries()) {
            logger.debug { "\tfound directory entry: ${if (dirEntry.isRegularFile()) "F" else "D"} ${dirEntry.normalize()}" }
            if (dirEntry.name.startsWith(".")) {
                logger.warn { "\tIgnored $dirEntry" }
                continue
            }

            if (dirEntry.isDirectory(LinkOption.NOFOLLOW_LINKS)) {
                if (dirAndDepth.second < maxDepth) {
                    subDirectories.push(dirEntry to dirAndDepth.second + 1)
                } else {
                    logger.warn { "\tIgnored sub directory $dirEntry" }
                }
            }
        }
    } while (subDirectories.isNotEmpty())
}
