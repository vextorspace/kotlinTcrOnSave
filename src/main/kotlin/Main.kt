package com.ronnev

fun main(args: Array<String>? = null) {
    val toWhom = args?.get(0) ?: "World"
    println(Greeting(toWhom).greet())
}