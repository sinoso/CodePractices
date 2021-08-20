package programmers

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    var stars = ""
    for(i in b downTo 1){
        for( y in a downTo 1){
            stars+="*"
        }
        stars+="\n"
    }
    println(stars)
}