package leetcode.medium

fun main() {
    println(letterCombinations("23"))
}

private fun letterCombinations(digits: String): List<String> {
    fun HashMap<Char, CharArray>.ad(c:Char,s:String){
        this[c] = s.toCharArray()
    }
    if (digits == "")
        return listOf()
    val array = digits.toCharArray()
    val charSet = HashMap<Char, CharArray>().apply {
        ad('2', "abc")
        ad('3', "def")
        ad('4', "ghi")
        ad('5', "jkl")
        ad('6', "mno")
        ad('7', "pqrs")
        ad('8', "tuv")
        ad('9', "wxyz")
    }
    var answerList = listOf("")
    for (char in array)
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