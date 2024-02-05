# SeaBaaS - Proof of Concept

## Overview

_Backend-as-a-Service_ (BaaS) refers to a platform that automates 
backend side development.

## Project goals
 
 * Read schema files on startup from a designated directory.
   * Investigate implementing external DSL as Kotlin custom script
     to avoid custom YAML descriptors. Kotlin script is experimental,
     where is a [proposal document](https://github.com/Kotlin/KEEP/blob/master/proposals/scripting-support.md)
     and some [examples](https://github.com/Kotlin/kotlin-script-examples).
     The whole idea looks worth trying: external schema definition files
     are exactly the same as definition in the code (e.g. [TestSchemas.kt](src/test/kotlin/org/twowls/poc/seabaas/schema/dsl/TestSchemas.kt)).
 * Maintain an in-memory persistence layer for schema and data.
 * Expose schema objects via REST API according to schema.
 * Stream data updates via Web Socket.
 * Support multiple backends.
 * Provide a minimalistic UI for administration:
   * Build and JVM information.
   * List of problems occurred while loading source schemas.
   * Server status, endpoints and their statistics.
 * Docker and Kubernetes deployment.

## Notes

### Autocompletion and context for custom scripts in Idea

 * Project should use the same JDK version as IntelliJ Idea
 * Script definitions are discovered by `META-INF/kotlin/script/templates`
   * File names are fully qualified script definition classes (those annotated with `@KotlinScript`)
 * In IntelliJ Idea settings the custom script definition should be moved above `.kts` files
 * In IntelliJ Idea settings auto-reload should be enabled
 * Most likely Idea needs to be restarted when schema definition changes
   * Invalidation of caches does not seem necessary