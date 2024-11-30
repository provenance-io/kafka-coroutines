plugins {
	`kotlin-dsl`
}

val gradleNexusVersion = "2.0.0"
val kotlinVersion = "1.9.24"
val dokkaVersion = "1.9.20"
val ktLintVersion = "11.6.1"

repositories {
	gradlePluginPortal()
}

ext {
	set("kotlinVersion", kotlinVersion)
	set("ktLintVersion", ktLintVersion)
	set("dokkaVersion", dokkaVersion)
}

dependencies {
	implementation("io.github.gradle-nexus", "publish-plugin", gradleNexusVersion)
	implementation("org.jetbrains.kotlin", "kotlin-gradle-plugin", kotlinVersion)
	implementation("org.jlleitschuh.gradle", "ktlint-gradle", ktLintVersion)
	implementation("org.jetbrains.dokka", "dokka-gradle-plugin", dokkaVersion)
}
