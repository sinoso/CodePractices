package programmers.p2

fun main() {
    println(solution("aabbaccc"))
    println(solution("ababcdcdababcdcd"))
    println(solution("abcabcdede"))
    println(solution("abcabcabcabcdededededede"))
    println(solution("xababcdcdababcdcd"))
    println(solution("aaa"))
}

private fun solution(s: String): Int {
    var length = s.length
    var charArray = s.toCharArray()
    var min = s.length
    //아무리 길어도 절반초과부터는 압축이 불가능 .. length / 2
    for (size in 1..(length / 2)) {
        var currentLength = 0
        var count = 0
        var flag = false
        var nowArray = charArray.sliceArray(0 until size)
        var lastIdx = charArray.size / size

        for (idx in 1 until lastIdx) {
            for (subIdx in idx * size until size * (idx + 1)) {
                if (nowArray[subIdx % size] != charArray[subIdx]) {
                    flag = true
                    break
                }
            }
            if (!flag)
                count++

            if (flag) {
                flag = false
                nowArray = charArray.sliceArray(idx * size until size * (idx + 1))
                if (count != 0) {
                    count++
                    currentLength += size
                    while (count != 0) {
                        count /= 10
                        currentLength++
                    }
                } else
                    currentLength += size
            }
        }

        if (count != 0) {
            count++
            currentLength += size
            while (count != 0) {
                count /= 10
                currentLength++
            }
        } else {
            currentLength += size
        }
        if (charArray.size % size != 0)
            currentLength += charArray.size % size
        min = min.coerceAtMost(currentLength)
    }
    return min
}
//private fun solution2(s: String): Int {
//    var length = s.length
//    var charArray = s.toCharArray()
//    var min = s.length
//    //아무리 길어도 절반초과부터는 압축이 불가능 .. length / 2
//    for (size in 1..(length / 2)) {
//        var currentLength = 0
//        var count = 0
//        var flag = false
//        var nowArray = charArray.sliceArray(0 until size)
//        var lastIdx = charArray.size / size
//        for (idx in 1 until lastIdx) {
//
//            for (subIdx in idx * size until size * (idx + 1)) {
//                if (nowArray[subIdx % size] != charArray[subIdx]) {
//                    flag = true
//                    break
//                }
//            }
//            if (!flag)
//                count++
//
//            if (flag || idx == lastIdx - 1) {
//                flag = false
//                nowArray = charArray.sliceArray(idx * size until size * (idx + 1))
//                if (count != 0) {
//                    count++
//                    currentLength += size
//                    while (count != 0) {
//                        count /= 10
//                        currentLength++
//                    }
//                } else
//                    currentLength += size
//            }
//        }
//        if (count != 0) {
//            count++
//            currentLength += size
//            while (count != 0) {
//                count /= 10
//                currentLength++
//            }
//        } else {
//            currentLength += size
//        }
//        if (charArray.size % size != 0)
//            currentLength += charArray.size % size
//
//        min = min.coerceAtMost(currentLength)
//    }
//    return min
//}