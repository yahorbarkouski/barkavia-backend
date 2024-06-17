import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    group = "com.barkavia"

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = JavaVersion.VERSION_21.toString()
        }
    }
}
