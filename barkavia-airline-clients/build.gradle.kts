plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework:spring-tx")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    testImplementation("org.springframework.cloud:spring-cloud-contract-wiremock:4.1.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
