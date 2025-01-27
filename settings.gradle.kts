rootProject.name = "ft-coroutines"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

// Adapted from https://stackoverflow.com/a/60456440
gradle.rootProject {
    /**
     * This library and all subprojects are set to the same shared version.
     * This is the only place the version should be updated:
     */
    val libraryVersion =
        rootProject.property("libraryVersion") ?: error("Missing libraryVersion - check gradle.properties")
    allprojects {
        group = "tech.figure.coroutines"
        version = libraryVersion
        description =
            "Library for reading from and writing to Kafka from Kotlin coroutines"
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("cli")
include("ft-coroutines-core")
include("ft-coroutines-retry")
include("ft-coroutines-kafka")
include("ft-coroutines-kafka-retry")

plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.20"
}

gitHooks {
    preCommit {
        from {
            """
                echo "Running pre-commit ktlint check"
                ./gradlew ktlintCheck
            """.trimIndent()
        }
    }
    createHooks()
}
