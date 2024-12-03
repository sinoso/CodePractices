package leetcode.medium

import tools.checkResult


fun main() {
    checkResult(
        expected = "Leetcode Helps Me Learn",
        actual = addSpaces(s = "LeetcodeHelpsMeLearn", spaces = intArrayOf(8, 13, 15))
    )
    checkResult(
        expected = "i code in py thon",
        actual = addSpaces(s = "icodeinpython", spaces = intArrayOf(1,5,7,9))
    )

    checkResult(
        expected = " s p a c i n g",
        actual = addSpaces(s = "spacing", spaces = intArrayOf(0,1,2,3,4,5,6))
    )
}


private fun addSpaces(s: String, spaces: IntArray): String {
    if (spaces.isEmpty())
        return s
    val sb = StringBuilder().apply {
        ensureCapacity(s.length + spaces.size)
    }
    val sLastIndex = s.lastIndex
    var sIndex = 0
    // 1 4
    for (spaceIndex in spaces) {
        // 2
        while (spaceIndex > sIndex) {
            sb.append(s[sIndex])
            sIndex++
        }
        //3
        sb.append(" ")
        sb.append(s[sIndex])
        sIndex++
    }
    //5
    while (sIndex <= sLastIndex) {
        sb.append(s[sIndex])
        sIndex++
    }
    return sb.toString()
}
// 1. space 확인
// 2. space의 위치까지 진행
// 3. 빈칸추가 및 글자 추가
// 4. space를 다 쓸때까지 반복
// 5. 나머지를 전부 더함.

//space의 index는 s의 lastIndex 보다 작다는걸 보장받음
//space는 항상 해당 index의 글자 앞에 추가됨(한칸밀려난다는의미)