package leetcode.medium


fun main() {

}

// 21 : 51 ~ 22:02
class BrowserHistory(homepage: String) {
    private val headNode = HistoryNode(null, null, homepage)
    private var currentNode = headNode
    fun visit(url: String) {
        val newNode = HistoryNode(pre = currentNode, url = url)
        currentNode.next = newNode
        currentNode = newNode
    }

    fun back(steps: Int): String {
        var count = steps
        while (count-- > 0) {
            val preNode = currentNode.pre ?: break
            currentNode = preNode
        }
        return currentNode.url
    }

    fun forward(steps: Int): String {
        var count = steps
        while (count-- > 0) {
            val nextNode = currentNode.next ?: break
            currentNode = nextNode
        }
        return currentNode.url
    }

}

data class HistoryNode(
    var pre: HistoryNode? = null,
    var next: HistoryNode? = null,
    val url: String
)
