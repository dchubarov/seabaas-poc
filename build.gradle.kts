plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.twowls.poc.seabaas"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val jacksonVersion by properties
    val kotlinLoggingVersion by properties
    val logbackVersion by properties
    val slf4jVersion by properties

    // Jackson
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    // Logging
    api("org.slf4j:slf4j-api:$slf4jVersion")
    api("io.github.oshai:kotlin-logging-jvm:$kotlinLoggingVersion")
    runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")

    // Test-only dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}