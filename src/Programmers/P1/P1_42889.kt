package Programmers

import java.util.*;
import java.util.Map.Entry.comparingByValue
import java.util.stream.Collectors

fun main() {
//    println(solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).contentToString())
    println(solution(5, intArrayOf(2,1,2,4,2,4,3,3)).contentToString())
//    println(solution(4, intArrayOf(4, 4, 4, 4, 4)).contentToString())
}

private fun solution(N: Int, stages: IntArray): IntArray {
    var stageClears = IntArray(N)
    var usersInStage = IntArray(N)
    for (i in stages) {
        for (j in 0 until i) {
            if (j == N) break
            usersInStage[j]++
        }
        for (j in 0 until i - 1) {
            stageClears[j]++
        }
    }
    var map = HashMap<Int, Double>()
    for (i in 0 until N) {
        if(usersInStage[i]!=0){
            map[i + 1] = (usersInStage[i].toDouble() - stageClears[i]) / usersInStage[i]
        }else {
            map[i + 1] = 0.0
        } 
    }
    return map.entries.stream()
            .sorted(comparingByValue()).collect(Collectors.toList()).sortedByDescending { mutableEntry -> mutableEntry.value }.map { entry -> entry.key }.toIntArray()
}