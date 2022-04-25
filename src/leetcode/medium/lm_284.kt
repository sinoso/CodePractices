package leetcode.medium

fun main() {

}

class PeekingIterator(private val iterator: Iterator<Int>) : Iterator<Int> {
    private var currentValue = iterator.next()
    private var isThisHasNext = iterator.hasNext()

    fun peek(): Int = currentValue

    override fun next(): Int {
        val returnValue = currentValue
        isThisHasNext = iterator.hasNext()
        if (isThisHasNext)
            currentValue = iterator.next()
        return returnValue
    }

    override fun hasNext(): Boolean = isThisHasNext
}
