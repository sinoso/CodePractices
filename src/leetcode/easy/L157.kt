package leetcode.easy

fun main() {

}


//class Solution : Reader4() {
//    /**
//     * @param buf Destination buffer
//     * @param n Number of characters to read
//     * @return The number of actual characters read
//     */
//    override fun read(buf: CharArray, n: Int): Int {
//        var count = 0
//        val buf4 = CharArray(4)
//        while (count < n) {
//            val charNumberOfBuf4 = read4(buf4)
//            for (i in 0 until charNumberOfBuf4) {
//                if (count == n)
//                    return count
//                buf[count] = buf4[i]
//                count++
//            }
//            if (charNumberOfBuf4 < 4) {
//                return count
//            }
//        }
//        return count
//    }
//}