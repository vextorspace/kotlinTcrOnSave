package com.ronnev

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class Greeting() {
    fun greet(toWhom: String = "World"): String {
        return "Hello $toWhom!"
    }
}

class GreetingTest : ExpectSpec({
    context("Greeting") {
        expect("should return Hello World!") {
            Greeting().greet() shouldBe "Hello World!"
        }
    }

    context("Greeting with Bob") {
        expect("should return Hello Bob!") {
            Greeting().greet("Bob") shouldBe "Hello Bob!"
        }
    }

})