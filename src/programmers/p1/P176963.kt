package programmers.p1

fun main() {
}

private fun solution(
    name: Array<String>,
    yearning: IntArray,
    photo: Array<Array<String>>
): IntArray {
    val hashMap = HashMap<String, Int>()
    for (i in name.indices) { hashMap[name[i]] = yearning[i] }
    return photo.map { persons -> persons.map { hashMap[it] ?: 0 }.sum() }.toIntArray()
}
