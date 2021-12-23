package leetcode.medium

import leetcode.testclass.ImmutableListNode

fun main() {
    printLinkedListInReverse(
        ImmutableListNode(
            1,
            ImmutableListNode(
                2,
                ImmutableListNode(
                    3,
                    ImmutableListNode(4, null)
                )
            )
        )
    )
}

private fun printLinkedListInReverse(head: ImmutableListNode?) {
    if (head == null)
        return
    printLinkedListInReverse(head.getNext())
    head.printValue()
}

private fun printLinkedListInReverse2(head: ImmutableListNode?) {
    head?.getNext()?.let { printLinkedListInReverse(it) }
    head?.printValue()
}
