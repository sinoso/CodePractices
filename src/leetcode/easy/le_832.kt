package leetcode.easy

import tools.PrintArray

fun main() {
    flipAndInvertImage(
        arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0)
        )
    ).also(PrintArray::printArray2)
    flipAndInvertImage(
        arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0)
        )
    ).also(PrintArray::printArray2)
}

private fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
    var left: Int
    var right: Int
    for (array in image) {
        left = 0
        right = array.lastIndex
        while (left < right) {
            //flip
            array[left] = array[left] xor array[right]
            array[right] = array[left] xor array[right]
            array[left] = array[left] xor array[right]
            //invert
            array[left] = array[left] xor 1
            array[right] = array[right] xor 1
            //idx move
            left++
            right--
        }
        if (left == right)
            array[left] = array[left] xor 1
    }
    return image
}

private fun flipAndInvertImage2(image: Array<IntArray>): Array<IntArray> =
    image.apply {
        forEach { array ->
            array.reverse()
            array.indices.forEach { idx ->
                array[idx] = array[idx] xor 1
            }
        }
    }

