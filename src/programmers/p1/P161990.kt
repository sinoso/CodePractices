package programmers

fun main() {
    solution(arrayOf(".#...", "..#..", "...#."))
}

private fun solution(wallpaper: Array<String>): IntArray {
    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE
    val horizontalRange = wallpaper.first().indices
    for (x in wallpaper.indices) {
        for (y in horizontalRange) {
            if (wallpaper[x][y] == '#') {
                minX = x.coerceAtMost(minX)
                maxX = (x + 1).coerceAtLeast(maxX)
                minY = y.coerceAtMost(minY)
                maxY = (y + 1).coerceAtLeast(maxY)
            }
        }
    }
    return intArrayOf(minX, minY, maxX, maxY)
}

//ㅁ◼ㅁㅁㅁ
//ㅁㅁㅁ◼ㅁ
//ㅁ◼ㅁㅁㅁ
//ㅁㅁㅁ◼ㅁ
//◼ㅁㅁㅁ◼