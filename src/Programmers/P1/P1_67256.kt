package Programmers

import kotlin.math.absoluteValue

fun main() {
    println(solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
    println(solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left"))
    println(solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right"))
}

private fun solution(numbers: IntArray, hand: String): String {
    var answer = ""
    var leftHandPos = 10
    var rightHandPos = 12
    for (num in numbers) {
        var number = num
        if (number == 0)
            number = 11
        when (number) {
            1, 4, 7 -> {
                leftHandPos = number
                answer += "L"
            }
            3, 6, 9 -> {
                rightHandPos = number
                answer += "R"
            }
            else -> {
                var leftDistance = (number - leftHandPos).absoluteValue / 3 + (number - leftHandPos).absoluteValue % 3
                var rightDistance = (number - rightHandPos).absoluteValue / 3 + (number - rightHandPos).absoluteValue % 3
                when {
                    rightDistance - leftDistance < 0 -> {
                        rightHandPos = number
                        answer += "R"
                    }
                    rightDistance - leftDistance > 0 -> {
                        leftHandPos = number
                        answer += "L"
                    }
                    rightDistance - leftDistance == 0 -> {
                        if (hand == "left") {
                            leftHandPos = number
                            answer += "L"
                        }else{
                            rightHandPos = number
                            answer += "R"
                        }
                    }
                }
            }

        }
    }
    return answer
}