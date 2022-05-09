package leetcode.medium

fun main() {
    println(letterCombinations("23"))
}

private fun letterCombinations(digits: String): List<String> {
    if (digits == "")
        return listOf()
    val charSet = HashMap<Char, String>().apply {
        this['2'] = "abc"
        this['3'] = "def"
        this['4'] = "ghi"
        this['5'] = "jkl"
        this['6'] = "mno"
        this['7'] = "pqrs"
        this['8'] = "tuv"
        this['9'] = "wxyz"
    }
    var answerList = listOf("")
    for (char in digits)
        mutableListOf<String>().run {
            for (new in charSet[char]!!)
                for (old in answerList)
                    add(old + new)
            answerList = this
        }
    return answerList
}

//    0~8
//    00 01 02 10 11 12 20 21 22
//     0  1  2  0  1  2  0  1  2
//    0  0  0  1  1  1  2  2  2
//    111 112 113 121 122 123 131 132 133 211 212 213
//      0   1   2   0   1   2   0   1   2   0   1   2
//     0   0   0   1   1   1   2   2   2   0   0   0
//    0   0   0   0   0   0   0   0   0   1   1   1
//    000 001 002 010 011 012 020 021 022 100 101 102
