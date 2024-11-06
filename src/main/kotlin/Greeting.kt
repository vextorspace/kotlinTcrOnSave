package com.ronnev

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class Greeting(val toWhom: String = "World") {
    fun greet(): String {
        return "Hello $toWhom!"
    }
}

class GreetingTest : ExpectSpec({
    context("Greeting") {
        expect("should return Hello World!") {
            Greeting().greet() shouldBe "Hello World!"
        }
    }
})