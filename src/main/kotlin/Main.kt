package com.ronnev

import kotlin.collections.toList

fun main(args: Array<String>? = null) {
    val toWhom = args?.toList() ?: emptyList()
    println(Greeting().greet(toWhom))
}
