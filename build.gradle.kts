plugins {
    kotlin("jvm") version "2.0.20"
    java
    application
}

group = "com.ronnev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

configurations {
    create("unitTestImplementation") {
        extendsFrom(configurations.testImplementation.get())
    }
}

val kotestVersion = "6.0.0.M1"

dependencies {
    implementation(kotlin("test"))
    implementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    implementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

sourceSets {
    val main by getting {
        java.srcDir("src/main/kotlin")
        resources.srcDir("src/main/resources")
    }

    val unitTest by creating {
        java.srcDir("src/main/kotlin")
        resources.srcDir("src/test/resources")
    }
}

tasks {
    jar {
        exclude("**/*Test.class")
    }

    val unitTest by creating(Test::class) {
        useJUnitPlatform()
        testClassesDirs = sourceSets["unitTest"].output.classesDirs
        classpath = sourceSets["unitTest"].runtimeClasspath

        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }

        afterSuite(KotlinClosure2<TestDescriptor, TestResult, Unit>({ desc, result ->
            if (desc.parent == null) { // will match the outermost suite
                println("Summary Report: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} passed, ${result.failedTestCount} failed, ${result.skippedTestCount} skipped)")
            }
        }))
    }

    test {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }

        afterSuite(KotlinClosure2<TestDescriptor, TestResult, Unit>({ desc, result ->
            if (desc.parent == null) { // will match the outermost suite
                println("Summary Report: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} passed, ${result.failedTestCount} failed, ${result.skippedTestCount} skipped)")
            }
        }))

        dependsOn("unitTest")
    }
}

kotlin {
    jvmToolchain(21)
}

application {
   mainClass.set("com.ronnev.MainKt")
}