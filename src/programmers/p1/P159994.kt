package programmers.p1


fun main() {
    solution(arrayOf("i", "drink", "water"), arrayOf("want", "to"), arrayOf("i", "want", "to", "drink", "water"))

}

private fun solution(
    cards1: Array<String>,
    cards2: Array<String>,
    goal: Array<String>
): String {
    var index1 = 0
    var index2 = 0
    for (word in goal) {
        if (index1 < cards1.size && cards1[index1] == word) {
            index1++
            continue
        }
        if (index2 < cards2.size && cards2[index2] == word) {
            index2++
            continue
        }
        return "No"
    }
    return "Yes"
}
