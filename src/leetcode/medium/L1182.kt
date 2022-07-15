package leetcode.medium

fun main() {
    shortestDistanceColor(
        intArrayOf(1, 1, 2, 1, 3, 2, 2, 3, 3),
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 2),
            intArrayOf(6, 1)
        )
    )
//    shortestDistanceColor(
//        intArrayOf(1, 1, 2, 1, 2, 2, 2, 2, 2),
//        arrayOf(
//            intArrayOf(1, 3),
//            intArrayOf(2, 2),
//            intArrayOf(6, 1)
//        )
//    )
}

fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): List<Int> {
    val size = colors.size
    var lastColor1 = -size
    var lastColor2 = -size
    var lastColor3 = -size
    val color1Array = IntArray(colors.size) { -1 }
    val color2Array = IntArray(colors.size) { -1 }
    val color3Array = IntArray(colors.size) { -1 }
    for (i in colors.indices) {
        when (colors[i]) {
            1 -> {
                lastColor1 = i
                for (j in i - 1 downTo 0) {
                    if (color1Array[j]!=-1&&color1Array[j] < i - j)
                        break
                    color1Array[j] = i - j
                }
            }
            2 -> {
                lastColor2 = i
                for (j in i - 1 downTo 0) {
                    if (color2Array[j]!=-1&&color2Array[j] < i - j)
                        break
                    color2Array[j] = i - j
                }
            }
            3 -> {
                lastColor3 = i
                for (j in i - 1 downTo 0) {
                    if (color3Array[j]!=-1&&color3Array[j] < i - j)
                        break
                    color3Array[j] = i - j
                }
            }
        }
        if (lastColor1 != -size)
            color1Array[i] = i - lastColor1
        if (lastColor2 != -size)
            color2Array[i] = i - lastColor2
        if (lastColor3 != -size)
            color3Array[i] = i - lastColor3
    }
    return queries.map { (index, targetColor) ->
        when (targetColor) {
            1 -> color1Array[index]
            2 -> color2Array[index]
            else -> color3Array[index]
        }
    }
}
//0 1 2 3 4
//1 2 3 4 1
//0 1 2 1 0
