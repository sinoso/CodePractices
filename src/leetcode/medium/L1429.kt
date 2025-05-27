package leetcode.medium

import tools.checkResult


fun main() {
    val fu = FirstUnique(intArrayOf(2, 3, 5))
    checkResult(expected = 2, actual = fu.showFirstUnique())
    fu.add(5)
    checkResult(expected = 2, actual = fu.showFirstUnique())
    fu.add(2)
    checkResult(expected = 3, actual = fu.showFirstUnique())
    fu.add(3)
    checkResult(expected = -1, actual = fu.showFirstUnique())

}

private class FirstUnique(nums: IntArray) {
    private var headNode: Node? = null
    private var tailNode: Node? = null
    private val map = HashMap<Int, Node>()

    init {
        for (i in nums) {
            add(value = i)
        }
    }

    fun showFirstUnique(): Int {
        return headNode?.number ?: -1
    }

    fun add(value: Int) {
        when (map[value]) {
            Node.REMOVED -> return

            null -> {
                val newNode = Node(value)
                addNewNode(newNode)
                map[value] = newNode
            }

            else -> {
                removeNode(map[value]!!)
                map[value] = Node.REMOVED
            }
        }
    }

    private fun removeNode(node: Node) {
        when {
            //head
            node.prev == null -> {
                // head == tail only one Node
                if (node.next == null) {
                    tailNode = null
                }

                headNode = node.next
                headNode?.prev = null
            }
            //tail
            node.next == null -> {
                tailNode = node.prev
                tailNode?.next = null
            }

            else -> {
                node.prev?.next = node.next
                node.next?.prev = node.prev
            }
        }

        node.dispose()
    }

    private fun addNewNode(newNode: Node) {
        // list empty
        if (tailNode == null) {
            headNode = newNode
            tailNode = newNode
            return
        }
        tailNode!!.next = newNode
        newNode.prev = tailNode
        tailNode = newNode
    }

    private class Node(val number: Int, var prev: Node? = null, var next: Node? = null) {
        fun dispose() {
            prev = null
            next = null
        }

        companion object {
            val REMOVED = Node(-1)
        }
    }
}
//
//1. 첫번째를 보여 줄 수 있게 하려면? 큐 또는 링크드 리스트를 만든다.
//2. 큐 또는 링크드 리스트를 탐색해서 처리하려면 순차접근이 필요하고, 기존 링크드 리스트는 노드에 관한 접근을 주지 않음.
//3. 노드를 직접 구현.
//4. 노드를 관리 하는 map을 생성
//5. map을 통해 해당 노드들에 직접 접근
//6. 새값을 추가시 map에 접근 기존에 존재했다면 노드 제거, 없었다면 노드 추가.
//7. 첫유니크 요청시 리스트의 head 값을 제공