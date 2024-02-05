plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.twowls.poc.seabaas"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val jacksonVersion: String by project
    val kotlinLoggingVersion: String by project
    val logbackVersion: String by project
    val slf4jVersion: String by project
    val kotestVersion: String by project

    // Kotlin scripting
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    // Logging
    api("org.slf4j:slf4j-api:$slf4jVersion")
    api("io.github.oshai:kotlin-logging-jvm:$kotlinLoggingVersion")
    runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")

    // Test-only dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}