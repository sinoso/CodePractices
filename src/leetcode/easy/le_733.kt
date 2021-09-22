package leetcode.easy

fun main() {
//    tools.PrintArray.printArray2(floodFill(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)), 1, 1, 2))
//    tools.PrintArray.printArray2(floodFill(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)), 0, 0, 2))
    tools.PrintArray.printArray2(floodFill(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 1)), 1, 1, 1))
}

private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> = image.also { fillIt(image, sr, sc, newColor, image[sr][sc]) }


fun fillIt(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int, oldColor: Int) {
    if (newColor == oldColor)
        return
    if (image[sr][sc] != oldColor)
        return
    else
        image[sr][sc] = newColor
    //up
    if (sr > 0)
        fillIt(image, sr - 1, sc, newColor, oldColor)
    //down
    if (sr < image.lastIndex)
        fillIt(image, sr + 1, sc, newColor, oldColor)
    //left
    if (sc > 0)
        fillIt(image, sr, sc - 1, newColor, oldColor)
    //right
    if (sc < image[0].lastIndex)
        fillIt(image, sr, sc + 1, newColor, oldColor)
}
//private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray>
//= image.also { fillIt(image, sr, sc, newColor, image[sr][sc]) }
//
//
//fun fillIt(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int, oldColor: Int) {
//    if (image[sr][sc] != oldColor)
//        return
//    else
//        image[sr][sc] = newColor
//    //up
//    if (sr > 0)
//        fillIt(image, sr - 1, sc, newColor, oldColor)
//    //down
//    if (sr < image.lastIndex)
//        fillIt(image, sr + 1, sc, newColor, oldColor)
//    //left
//    if (sc > 0)
//        fillIt(image, sr, sc - 1, newColor, oldColor)
//    //right
//    if (sc < image[0].lastIndex)
//        fillIt(image, sr, sc + 1, newColor, oldColor)
//}