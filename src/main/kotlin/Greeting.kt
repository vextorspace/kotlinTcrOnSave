package com.ronnev

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class Greeting() {
    fun greet(toWhom: List<String>): String {
        val greetees =
                if (toWhom.isEmpty()) {
                    "World"
                } else {
                    toWhom.joinToString(" and ")
                }
        return "Hello ${greetees}!"
    }

    fun greetList(toWhom: List<String>): String {
        val greetees =
                if (toWhom.isEmpty()) {
                    "World"
                } else {
                    toWhom.joinToString(" and ")
                }
        return "Hello ${greetees}!"
    }
}

class GreetingTest :
        ExpectSpec({
            context("Greeting") {
                expect("should return Hello World!") {
                    Greeting().greet(emptyList()) shouldBe "Hello World!"
                }
            }

            context("Greeting with Bob") {
                expect("should return Hello Bob!") {
                    Greeting().greetList(listOf("Bob")) shouldBe "Hello Bob!"
                }
            }

            context("Greeting with Bob and Jen") {
                expect("should return Hello Bob and Jen!") {
                    Greeting().greetList(listOf("Bob", "Jen")) shouldBe "Hello Bob and Jen!"
                }
            }
        })
