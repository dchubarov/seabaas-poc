plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.twowls.poc.seabaas"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Logging
    api("org.slf4j:slf4j-api:2.0.11")
    api("io.github.oshai:kotlin-logging-jvm:6.0.3")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.14")

    // Test-only dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}