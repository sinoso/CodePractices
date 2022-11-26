package leetcode.easy

fun main() {

}

private fun countAsterisks(s: String): Int {
    var flag = true
    var answer = 0
    for(i in s.indices){
        if (s[i]=='|')
            flag = !flag
        if (flag && s[i]=='*')
            answer++
    }
    return answer
}
