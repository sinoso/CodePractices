package leetcode.easy

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(fizzBuzz(3).joinToString())
    println(fizzBuzz(5).joinToString())
    println(fizzBuzz(15).joinToString())
}

private fun fizzBuzz(n: Int): List<String> = LinkedList<String>().apply {
    for (i in 1..n) {
        val m3 = i % 3 == 0
        val m5 = i % 5 == 0
        if (m3 && m5)
            add("FizzBuzz")
        else if (m3)
            add("Fizz")
        else if (m5)
            add("Buzz")
        else
            add("$i")
    }
}


private fun fizzBuzz2(n: Int): List<String> = ArrayList<String>(n).apply {
    for (i in 1..n) {
        val m3 = i % 3 == 0
        val m5 = i % 5 == 0

        if (m3 && m5)
            add("FizzBuzz")
        else if (m3)
            add("Fizz")
        else if (m5)
            add("Buzz")
        else
            add("$i")
    }
}

private fun fizzBuzz3(n: Int): List<String> =
    (1..n).map {
        when {
            it % 15 == 0 -> "FizzBuzz"
            it % 3 == 0 -> "Fizz"
            it % 5 == 0 -> "Buzz"
            else -> "$it"
        }
    }

