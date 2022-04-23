package leetcode.medium

fun main() {
    val codec = Codec()
    val originalUrl = "https://leetcode.com/problems/encode-and-decode-tinyurl/"
//    val originalUrl = "https"
    println(codec.encode(originalUrl))
}

//-31//' '
class Codec {
    val map = HashMap<String, String>()
    var lastIndex = 1L

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val sb = StringBuilder()
        var currentIndex = lastIndex++
        while (currentIndex > 0) {
            sb.append(BASE62[(currentIndex % 62).toInt()])
            currentIndex /= 62
        }
        map[sb.toString()] = longUrl

        return sb.toString()
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return map[shortUrl]!!
    }

    companion object {
        val BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()
    }
}
