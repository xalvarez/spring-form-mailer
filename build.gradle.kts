import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    kotlin("plugin.spring") version "1.3.21"
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.1")
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