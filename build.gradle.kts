plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("kapt") version "1.9.25"
}

group = "com.coordi"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // SPRING
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Health Check
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // SWAGGER
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    // LOGGER
    implementation("org.slf4j:slf4j-api:2.0.13")

    // H2
    runtimeOnly("com.h2database:h2")
    // JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // QueryDSL
    implementation("com.querydsl:querydsl-jpa:5.1.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("jakarta.persistence:jakarta.persistence-api:3.1.0")
    kapt("jakarta.annotation:jakarta.annotation-api:2.1.1")

    // Test
    testImplementation("net.datafaker:datafaker:2.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// kapt 설정 - 오류 타입 무시 (예: 아직 생성되지 않은 클래스 처리용)
kapt {
    correctErrorTypes = true
}

/*
sourceSets {
    main {
        java {
            // Kotlin + QueryDSL에서 생성된 Q 클래스 경로 포함
            srcDirs("src/main/kotlin", "build/generated/source/kapt/main")
        }
    }
}
*/

// Java 컴파일러 설정
/*
tasks.withType<JavaCompile> {
    // 생성된 소스코드를 이 경로에 출력하도록 설정 (IDE 인식 보조)
    options.generatedSourceOutputDirectory = file("build/generated/source/kapt/main")
}
*/
