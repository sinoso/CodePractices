package leetcode.easy

fun main() {

}

private fun isPathCrossing(path: String): Boolean {
    val map = HashMap<Int, HashSet<Int>>()
    var x = 0
    var y = 0
    fun addMapPont(x: Int, y: Int): Boolean {
        val set = map[x] ?: HashSet()
        val addResult = set.add(y)
        map[x] = set
        return addResult
    }
    addMapPont(x, y)

    for (c in path) {
        when (c) {
            'N' -> y++
            'S' -> y--
            'W' -> x--
            'E' -> x++
        }
        val isVisitedPoint = !addMapPont(x, y)
        if (isVisitedPoint) {
            return true
        }
    }
    return false
}