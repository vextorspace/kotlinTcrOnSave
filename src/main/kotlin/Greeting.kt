package com.ronnev

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class Greeting() {
    fun greet(toWhom: List<String>): String {
        if (toWhom.isEmpty()) {
            return "Hello World!"
        }

        if (areMyBrothers(toWhom)) {
            return "Hello my Brothers!"
        }

        val greetees = toWhom.joinToString(" and ")
        return "Hello ${greetees}!"
    }

    fun areMyBrothers(toWhom: List<String>): Boolean {
        return toWhom.containsAll(listOf("Joel", "Jerome", "Mathew"))
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
                    Greeting().greet(listOf("Bob")) shouldBe "Hello Bob!"
                }
            }

            context("Greeting with Bob and Jen") {
                expect("should return Hello Bob and Jen!") {
                    Greeting().greet(listOf("Bob", "Jen")) shouldBe "Hello Bob and Jen!"
                }
            }

            context("Greeting with Joel and Jerome") {
                expect("should return Hello Joel and Jerome!") {
                    Greeting().greet(listOf("Joel", "Jerome")) shouldBe "Hello Joel and Jerome!"
                }
            }

            context("Greeting with Joel, Jerome, and Mathew") {
                expect("should return Hello my Brothers!") {
                    Greeting().greet(listOf("Joel", "Jerome", "Mathew")) shouldBe
                            "Hello my Brothers!"
                }
            }
        })
