package leetcode.medium

fun main() {
    with(LRUCache(2)) {
        put(1, 1)
        put(2, 2)
        println(get(1)) //1
        put(3, 3)
        println(get(2))//-1
        put(4, 4);
        println(get(1)) //-1
        println(get(3))//3
        println(get(4))//4
    }

    with(LRUCache(2)) {
        put(2, 1)
        put(1, 1)
        put(2, 3)
        put(4, 1)
        println(get(1)) //-1
        println(get(2))//3
    }
}

class LRUCache(val capacity: Int) {
    private val cache = LinkedHashMap<Int, Int>()
    fun get(key: Int): Int {
        val target = cache[key] ?: return -1
        cache.remove(key)
        cache[key] = target
        return target
    }

    fun put(key: Int, value: Int) {
        cache.remove(key)
        cache[key] = value
        if (cache.size > capacity)
            cache.remove(cache.keys.first())
    }
}

class LRUCache2(val capacity: Int) {
    private val hashMap = HashMap<Int, Element?>()
    private var head: Element? = null
    private var tail: Element? = null
    private var elementCount = 0

    fun get(key: Int): Int {
        val element = hashMap[key] ?: return -1
        if (element == head) return element.value
        if (element == tail) {
            tail = element.front
        } else {
            element.back!!.front = element.front
        }
        element.front!!.back = element.back
        element.back = head
        element.front = null
        head!!.front = element
        head = element
        return element.value
    }

    fun put(key: Int, value: Int) {
        val targetElement = hashMap[key]?.apply {
            this.value = value
        } ?: Element(key, value).also {
            hashMap[key] = it
            elementCount++
        }
        if (head == null) {
            head = targetElement
            tail = targetElement
        }
        if (targetElement == head) {
            return
        } else if (targetElement == tail) {
            targetElement.front!!.back = targetElement.back
            tail = targetElement.front
            targetElement.front = null
            head!!.front = targetElement
            targetElement.back = head
            head = targetElement
        } else {
            targetElement.front?.back = targetElement.back
            targetElement.back?.front = targetElement.front
            targetElement.front = null
            head?.front = targetElement
            targetElement.back = head
            head = targetElement
        }
        if (elementCount > capacity) {
            hashMap[tail!!.key] = null
            tail = tail!!.front
            tail!!.back = null
            elementCount--
        }
    }

    class Element(val key: Int, var value: Int, var front: Element? = null, var back: Element? = null)
}

