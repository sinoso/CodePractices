package leetcode.easy


fun main() {
}

class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val slots = intArrayOf(big, medium, small)
    fun addCar(carType: Int): Boolean = slots[carType - 1]-- > 0
}
