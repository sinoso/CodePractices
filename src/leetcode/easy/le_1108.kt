package leetcode.easy


fun main() {
    println(defangIPaddr("1.1.1.1"))
}


private fun defangIPaddr(address: String): String {
    val sb = StringBuffer()
    for (s in address)
        sb.append(if (s != '.') s else "[.]")
    return sb.toString()
}

private fun defangIPaddr2(address: String): String = address.replace(".", "[.]")