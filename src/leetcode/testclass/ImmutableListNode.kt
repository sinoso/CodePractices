package leetcode.testclass

class ImmutableListNode(private val value: Int, private val next: ImmutableListNode?) {

    fun getNext(): ImmutableListNode? = next
    fun printValue() {
        println(value)}
}
