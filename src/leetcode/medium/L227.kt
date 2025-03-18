package leetcode.medium

import printResult
import java.util.*

fun main() {
    printResult(actual = calculate("3+2*2/3"), expected = 4)
    printResult(actual = calculate("3+2*2/3+3"), expected = 7)
    printResult(actual = calculate("14-3/2"), expected = 13)
}
private fun calculate(s: String): Int {
    val numberDeque: Deque<Int> = LinkedList()
    val operatorDeque: Deque<Char> = LinkedList()

    var number = 0
    for (c in s) {
        when (c) {
            '-', '+', '*', '/' -> {
                numberDeque.add(number)
                number = 0
                operatorDeque.add(c)
            }

            in '0'..'9' -> {
                number = (c - '0') + number * 10
            }
        }
    }
    numberDeque.add(number)
    var answer = 0
    val numStack: Stack<Int> = Stack()
    val operatorStack: Stack<Boolean> = Stack()
    while (operatorDeque.isNotEmpty()) {
        when (operatorDeque.peekLast()) {
            '-' -> {
                operatorDeque.pollLast()
                answer -= numberDeque.pollLast()
            }

            '+' -> {
                operatorDeque.pollLast()
                answer += numberDeque.pollLast()
            }

            '*' -> {
                while (operatorDeque.peekLast() == '*' || operatorDeque.peekLast() == '/') {
                    numStack.push(numberDeque.pollLast())
                    operatorStack.push(operatorDeque.pollLast() == '*')
                }
                var result = numberDeque.pollLast()
                while (operatorStack.isNotEmpty()) {
                    if (operatorStack.pop())
                        result *= numStack.pop()
                    else
                        result /= numStack.pop()
                }
                numberDeque.add(result)
            }

            '/' -> {
                while (operatorDeque.peekLast() == '*' || operatorDeque.peekLast() == '/') {
                    numStack.push(numberDeque.pollLast())
                    operatorStack.push(operatorDeque.pollLast() == '*')
                }
                var result = numberDeque.pollLast()
                while (operatorStack.isNotEmpty()) {
                    if (operatorStack.pop())
                        result *= numStack.pop()
                    else
                        result /= numStack.pop()
                }
                numberDeque.add(result)
            }
        }

    }
    return numberDeque.pop() + answer
}