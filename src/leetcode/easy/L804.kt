package leetcode.easy

import printResult

fun main() {
    printResult(uniqueMorseRepresentations(arrayOf("gin","zen","gig","msg")),2)
    printResult(uniqueMorseRepresentations(arrayOf("a")),1)
}
private fun uniqueMorseRepresentations(words: Array<String>): Int {
    val table = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
    val set = hashSetOf<String>()
    for (word in  words){
        val sb = StringBuilder()
        for (c in word)
            sb.append(table[c-'a'])
        set.add(sb.toString())
    }
    return set.size
}
private fun uniqueMorseRepresentations2(words: Array<String>): Int {
    val table = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
    val map = hashMapOf<Char,String>()
    val set = hashSetOf<String>()
    var idx = 0
    for (c in 'a'..'z'){
        map[c] = table[idx++]
    }
    for (word in  words){
        val sb = StringBuilder()
        for (c in word)
            sb.append(map[c])
        set.add(sb.toString())
    }
    return set.size
}
