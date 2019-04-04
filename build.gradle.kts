import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    kotlin("plugin.spring") version "1.3.21"
    kotlin("plugin.allopen") version "1.3.21"
    kotlin("plugin.noarg") version "1.3.21"
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.slf4j:slf4j-api:1.7.26")

    runtime("org.webjars:webjars-locator-core:0.37")
    runtime("org.webjars:bootstrap:4.3.1")

    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.github.tomakehurst:wiremock:2.22.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions {
        jvmTarget = "1.8"
        javaParameters = true
    }
}
val compileTestKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions {
        jvmTarget = "1.8"
        javaParameters = true
    }
}

noArg {
    annotation("org.springframework.boot.context.properties.ConfigurationProperties")
    annotation("com.fasterxml.jackson.annotation.JsonTypeName")
}