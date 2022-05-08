package leetcode.medium

import java.util.*


fun main() {

}

class NestedIterator(nestedList: List<NestedInteger>) {
    private val stack = LinkedList<NestedInteger>()
    init {
        fun split(nestedInteger: NestedInteger){
            if(nestedInteger.isInteger())
                stack.offerFirst(nestedInteger)
            else{
                nestedInteger.getList()!!
                    .forEach(::split)
            }
        }
        nestedList.forEach(::split)
    }

    fun next(): Int = stack.pollLast().getInteger()!!


    fun hasNext(): Boolean = stack.isNotEmpty()
}

class NestedInteger {
    constructor()

    constructor(value: Int)

    fun isInteger(): Boolean = false

    fun getInteger(): Int? = 0

    fun setInteger(value: Int): Unit {}

    fun add(ni: NestedInteger): Unit {}

    fun getList(): List<NestedInteger>? = listOf()
}
