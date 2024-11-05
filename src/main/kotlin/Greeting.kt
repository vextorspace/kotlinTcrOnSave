package com.ronnev

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class Greeting {
    fun greet(): String {
        return "Hello World!"
    }
}

class GreetingTest : ExpectSpec({
    context("Greeting") {
        expect("should return Hello World!") {
            Greeting().greet() shouldBe "Hello World!"
        }
    }
})