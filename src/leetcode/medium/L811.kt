package leetcode.medium


fun main() {
    subdomainVisits(arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"))
}

//19:55 ~ 20:22
fun subdomainVisits(cpdomains: Array<String>): List<String> {
    val resultMap = HashMap<String, Int>()
    cpdomains.forEach {
        it.split(" ")
            .let { (value, domain) ->
                val req = value.toInt()
                var startIndex = 0
                val lastIndex = domain.lastIndex
                resultMap[domain] = (resultMap[domain] ?: 0) + req
                while (startIndex < lastIndex) {
                    if (domain[startIndex] == '.') {
                        val key = domain.substring(startIndex + 1..lastIndex)
                        resultMap[key] = (resultMap[key] ?: 0) + req
                    }
                    startIndex++
                }
            }
    }
    return resultMap.map { "{${it.value} ${it.value}}" }
}
