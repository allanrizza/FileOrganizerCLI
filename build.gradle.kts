import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar // CORRETO

plugins {
    kotlin("jvm") version "2.2.0"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.6")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(24)
}

application {
    mainClass.set("org.example.MainKt")
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("file-organizer")
    archiveClassifier.set("")
    archiveVersion.set("1.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}