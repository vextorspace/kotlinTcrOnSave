package com.ronnev

fun main(args: Array<String>? = null) {
    val toWhom = args?.getOrNull(0) ?: "World"
    println(Greeting().greet(toWhom))
}