package leetcode.easy

import printResult

fun main() {
    printResult(actual = isIsomorphic(s = "egg", t = "add"), expected = true)
    printResult(actual = isIsomorphic(s = "foo", t = "bar"), expected = false)
    printResult(actual = isIsomorphic(s = "paper", t = "title"), expected = true)
    printResult(actual = isIsomorphic(s = "badc", t = "baba"), expected = false)
}

private fun isIsomorphic(s: String, t: String): Boolean {
    //map 을 확인한다. map에 없다면 저장하고 넘어간다.
    //map에 있다면 동일한지 확인한다. 동일하다면 계속한다.
    // 아니라면 false를 리턴한다.
    val mapS = HashMap<Char, Char>()
    val mapT = HashMap<Char, Char>()
    for (i in s.indices) {
        val mappedS = mapS[s[i]]
        val mappedT = mapT[t[i]]
        when {
            mappedS == null && mappedT == null -> {
                mapS[s[i]] = t[i]
                mapT[t[i]] = s[i]
            }
            mappedS == t[i] && mappedT == s[i] -> continue
            else -> return false
        }
    }
    return true
}