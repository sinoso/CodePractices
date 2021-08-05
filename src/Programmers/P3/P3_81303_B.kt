package Programmers.P2

import java.util.*

fun main() {
    println(solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z")))
    println(solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C")))
}



//failed at Efficiency
private fun acc(idx: Int, cells: Array<Boolean>, limit: Int, prefix: Int): Int {
    var temp = idx
    var count = 0
    while (count < limit) {
        temp += prefix
        if (cells[temp])
            count++
    }
    return temp
}
private fun solution(n: Int, k: Int, cmd: Array<String>): String {
    var idx = k
    var stack = Stack<Int>()
    var cells = Array(n) { true }
    for (command in cmd) {
        when (command[0]) {
            'U' -> idx = acc(idx, cells, command.slice(2..command.lastIndex).toInt(), -1)
            'D' -> idx = acc(idx, cells, command.slice(2..command.lastIndex).toInt(), 1)
            'C' -> {
                cells[idx] = false
                stack.push(idx)
                var temp = idx
                while (temp++ < n - 1) {
                    if (cells[temp]) {
                        idx = temp
                        break
                    }
                }
                temp = idx
                if (!cells[idx])
                    while (temp-- > 0) {
                        if (cells[temp]) {
                            idx = temp
                            break
                        }
                    }
            }
            'Z' -> cells[stack.pop()] = true
        }
    }
    var sb = StringBuffer()
    for (boolean in cells) {
        if (boolean) {
            sb.append('O')
            continue
        }
        sb.append('X')
    }
    return sb.toString()
}

//private fun solution(n: Int, k: Int, cmd: Array<String>): String {
//    var idx = k
//    var stack = Stack<Pair<Int, Int>>() // first = idx second  = value
//    var cells = MutableList(n) { v -> v }
//    for (command in cmd) {
//        when (command[0]) {
//            'U' -> {
//                idx -= command.slice(2..command.lastIndex).toInt()
//            }
//            'D' -> {
//                idx += command.slice(2..command.lastIndex).toInt()
//            }
//            'C' -> {
//                stack.push(Pair(idx, cells[idx]))
//                cells.removeAt(idx)
//
//                if (idx > cells.lastIndex)
//                    idx = cells.lastIndex
//            }
//            'Z' -> {
//                var value = stack.pop() //first = index second = value
//                if (value.first < idx) //현재 인덱스 보다 앞에 추가시 선택된 행이 변하면 안됨, idx는 1 증가 되어야함
//                    idx++
//                cells.add(value.first, value.second)
//            }
//        }
//    }
//    var sb = StringBuffer()
//    var lastValue = 0
//    for (i in cells) {
//        var gap = i - lastValue
//        for (j in 2..gap) {
//            sb.append('X')
//        }
//        sb.append('O')
//        lastValue = i
//    }
//    return sb.toString()
//}


//private fun solution(n: Int, k: Int, cmd: Array<String>): String {
//    var idx = k
//    var stack = Stack<Pair<Int, Int>>() // first = idx second  = value
//    var cells = MutableList(n) { v -> v }
//    for (command in cmd) {
//        when (command[0]) {
//            'U' -> {
//                idx -= command.slice(2..command.lastIndex).toInt()
//            }
//            'D' -> {
//                idx += command.slice(2..command.lastIndex).toInt()
//            }
//            'C' -> {
//                stack.push(Pair(idx, cells[idx]))
//                cells.removeAt(idx)
//
//                if (idx > cells.lastIndex)
//                    idx = cells.lastIndex
//            }
//            'Z' -> {
//                var value = stack.pop() //first = index second = value
//                if (value.first < idx) //현재 인덱스 보다 앞에 추가시 선택된 행이 변하면 안됨, idx는 1 증가 되어야함
//                    idx++
//                cells.add(value.first, value.second)
//            }
//        }
//    }
//    var sb = StringBuffer()
//    var list = stack.map { it.second }.sorted()
//
//    idx = 0
//    if (list.isEmpty())
//        return sb.also { for (i in 0 until n) sb.append('O') }.toString()
//
//    for (i in 0 until n) {
//        if (idx < list.size && i == list[idx]) {
//            sb.append('X')
//            idx++
//            continue
//        }
//        sb.append('O')
//    }
//    return sb.toString()
//}