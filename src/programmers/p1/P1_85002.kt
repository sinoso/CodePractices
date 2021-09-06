package programmers.p1

fun main() {
    println(solution(intArrayOf(50,82,75,120), arrayOf("NLWL","WNLL","LWNW","WWLN")).contentToString())
    println(solution(intArrayOf(50,50,50,50), arrayOf("NLWL","WNLL","LWNW","WWLN")).contentToString())
    println(solution(intArrayOf(120,75,82,50), arrayOf("NLWL","WNLL","LWNW","WWLN")).contentToString())
    println(solution(intArrayOf(145,92,86), arrayOf("NLW","WNL","LWN")).contentToString())
    println(solution(intArrayOf(60, 70, 60), arrayOf("NNN", "NNN", "NNN")).contentToString())
    println(solution(intArrayOf(60,60,70), arrayOf("NNW","NNW","LLN")).contentToString())
}

private fun solution(weights: IntArray, head2head: Array<String>): IntArray {
    var answer = IntArray(weights.size) { v -> v + 1 }
    var winRate = DoubleArray(weights.size)
    var heavyWins = IntArray(weights.size)
    for (index in head2head.indices) {
        var value = head2head[index]
        var wins = 0
        var fights = 0
        for (i in value.indices)
            when (value[i]) {
                'W' -> {
                    fights++
                    wins++
                    if (weights[index] < weights[i])
                        heavyWins[index]++
                }
                'L' -> fights++
                else -> {
                }
            }
        if (wins == 0 || fights == 0)
            winRate[index] = 0.0
        else
            winRate[index] = (wins / fights.toDouble())
    }

    return answer.sortedWith(compareByDescending<Int> { winRate[it - 1] }.thenByDescending { heavyWins[it - 1] }.thenByDescending { weights[it - 1] }.thenBy { it }).toIntArray()
}
