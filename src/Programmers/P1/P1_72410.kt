package Programmers

fun main() {
    println(solution("z-+.^."));
    println(solution("=.="));
    println(solution("123_.def"));
    println(solution("abcdefghijklmnp.y"));
    println(solution("b......@"));
    println(solution("-_.~!@#$%^&*()=+[{]}:?,<>/._-"))
    println(solution("...!@BaT#*..y.abcdefghijklm"))
    println(solution(" "))
}

private fun solution(new_id: String): String =
        new_id.toLowerCase().replace("""([^a-z0-9-_. ])""".toRegex(), "")
                .replace("[.]+".toRegex(), ".")
                .removeSuffix(".").removePrefix(".")
                .ifBlank { "a" }
                .let { if (it.length > 15) it.substring(0..14) else it }
                .removeSuffix(".")
                .let { if (it.length < 3) it.padEnd(3, it[it.lastIndex]) else it }

private fun solution2(new_id: String): String {
    var answer: String = new_id
    //step 1
    //step 2
    answer = answer.toLowerCase().replace("""([^a-z0-9-_. ])""".toRegex(), "")
    answer = answer.replace("[.]+".toRegex(), ".")
    answer = answer.removeSuffix(".").removePrefix(".").ifBlank { "a" }
    answer = answer.let { if (it.length > 15) it.substring(0..14) else it }
    answer = answer.removeSuffix(".")
    answer = answer.let { if (answer.length < 3) it.padEnd(3, it[it.lastIndex]) else it }




    return answer
}