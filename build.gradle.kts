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
        testClassesDirs = sourceSets["unitTest"]
            .output
            .classesDirs
        classpath = sourceSets["unitTest"].runtimeClasspath

        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
            exceptionFormat = org.gradle
                .api
                .tasks
                .testing
                .logging
                .TestExceptionFormat
                .FULL
        }

        displayResultsOfTests()
    }

    test {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }

        displayResultsOfTests()

        dependsOn("unitTest")
    }
}

kotlin {
    jvmToolchain(21)
}

application {
   mainClass.set("com.ronnev.MainKt")
}

fun Test.displayResultsOfTests() {
    afterSuite(
        KotlinClosure2<TestDescriptor, TestResult, Unit>(
            { desc, result ->
                if (desc.parent == null) {
                    print("Summary Report: ")
                    print("${result.resultType} (${result.testCount} tests,")
                    print(" ${result.successfulTestCount} passed,")
                    print(" ${result.failedTestCount} failed,")
                    println(" ${result.skippedTestCount} skipped)")
                }
            })
    )
}