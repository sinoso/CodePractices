package leetcode.easy


fun main() {
    isRectangleOverlap(intArrayOf(0,0,2,2),intArrayOf(1,1,3,3))
}
//0 = x1,  1 = y1, 2 = x2 , 3 = y2

//        x2y2
//x1y1
//    2 3
//0 1
private fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    if ((rec2[0] < rec1[0] && rec2[2] <= rec1[0]) || (rec2[0] >= rec1[2] && rec2[2] > rec1[2]))
        return false
    if ((rec2[1] < rec1[1] && rec2[3] <= rec1[1]) || (rec2[1] >= rec1[3] && rec2[3] > rec1[3]))
        return false
    return true
}
