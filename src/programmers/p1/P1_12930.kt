package programmers

fun main() {
    println(solution("try hello world"))
}

private fun solution(s: String): String {
    var splited= s.split(" ").toMutableList()
    var size = splited.size
    for(i in 0 until splited.size){
        var oneString: CharArray = splited[i].toCharArray()
        for (j in 0 until oneString.size step 2){
            oneString[j] = oneString[j].toUpperCase()
        }
        for (j in 1 until oneString.size step 2){
            oneString[j] = oneString[j].toLowerCase()
        }
        splited[i] = String(oneString)
    }
    return splited.joinToString(" ")
}