import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
		maven("https://repo.spring.io/milestone")
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RC1")
		classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.2")
	}
}

apply {
	plugin("org.springframework.boot")
	plugin("org.junit.platform.gradle.plugin")
}

plugins {
	val kotlinVersion = "1.2.21"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
	id("io.spring.dependency-management") version "1.0.4.RELEASE"
}

version = "1.0.0-SNAPSHOT"

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}

repositories {
	mavenCentral()
	maven("http://repo.spring.io/milestone")
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web")
	compile("org.springframework.boot:spring-boot-starter-data-redis")
	compile("org.springframework.boot:spring-boot-starter-data-jpa:1.5.10.RELEASE")
	runtime("org.springframework.boot:spring-boot-devtools")
	compile("com.h2database:h2")
	compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("mysql:mysql-connector-java")
    compile("redis.clients:jedis:2.9.0")
    compile("io.springfox:springfox-swagger2:2.7.0")
    compile("io.springfox:springfox-swagger-ui:2.7.0")


    testCompile("org.springframework.boot:spring-boot-starter-test") {
		exclude(module = "junit")
	}
	testCompile("org.junit.jupiter:junit-jupiter-api")
	testRuntime("org.junit.jupiter:junit-jupiter-engine")
}

