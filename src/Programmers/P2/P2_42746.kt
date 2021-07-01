package Programmers.P2

fun main() {
    println(solution(intArrayOf(6, 10, 2)))
    println(solution(intArrayOf(3, 30, 34, 5, 9)))
    println(solution(intArrayOf(10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))//987654321101000
    println(solution(intArrayOf(412, 41)))//41412
    println(solution(intArrayOf(303,30)))//30330
    println(solution(intArrayOf(0,0)))//30330
}

private fun solution(numbers: IntArray): String {
    var list = mutableListOf<String>()
    numbers.forEach { v-> list.add(v.toString()) }
    list.also {
        it.sortWith(kotlin.Comparator {
            o1:String, o2:String ->  (o1+o2).compareTo(o2+o1)})
    }
    list.reverse()
    var result = list.stream().reduce { a: String, b: String -> a + b }.get()
    return if(result[0]=='0'){
        "0"
    }else
        result
}

private fun solution2(numbers: IntArray): String {
    var list = mutableListOf<String>()
    numbers.forEach { v-> list.add(v.toString()) }
    list.also {
        it.sortWith(kotlin.Comparator {
            o1:String, o2:String ->  (o1+o2).compareTo(o2+o1)})
    }
    list.reverse()
    return if(list.stream().mapToInt { v->v.toInt() }.reduce{ a:Int, b:Int -> a+b}.asInt==0){
        "0"
    }else
        list.stream().reduce { a: String, b: String -> a + b }.get()
}
