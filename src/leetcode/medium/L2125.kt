package leetcode.medium


fun main() {

}

private fun numberOfBeams(bank: Array<String>): Int =
    bank.map { it.count { c -> c == '1' } }
        .filter { it != 0 }
        .fold(0 to 0) { (acc, lastValue), i ->
            (acc + lastValue * i) to i
        }.first

private fun numberOfBeams2(bank: Array<String>): Int =
    bank.map { it.count { c -> c == '1' } }
        .filter { it != 0 }
        .run {
            var answer = 0
            for (i in 1..lastIndex) {
                answer += this[i] * this[i - 1]
            }
            answer
        }
