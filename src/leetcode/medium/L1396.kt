package leetcode.medium

import kotlin.collections.HashMap


fun main() {

}

class UndergroundSystem() {
    private val ticketMap = HashMap<Int, Pair<String, Int>>()
    private val routeMap = HashMap<Pair<String, String>, IntArray>()
    fun checkIn(id: Int, stationName: String, t: Int) {
        ticketMap[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val (startStation, startTime) = ticketMap[id]!!
        val route = Pair(startStation, stationName)
        val time = t - startTime

        routeMap[route]?.let {
            it[0] += time
            it[1]++
        } ?: run {
            routeMap[route] = intArrayOf(time, 1)
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double =
        routeMap[Pair(startStation, endStation)]!!.run { this[0] / this[1].toDouble() }
}

//class UndergroundSystem() {
//    private val checkerMap = HashMap<Int, Ticket>()
//    private val routeMap = HashMap<String, AverageContainer>()
//    fun checkIn(id: Int, stationName: String, t: Int) {
//        checkerMap[id] = Ticket(stationName, t)
//    }
//
//    fun checkOut(id: Int, stationName: String, t: Int) {
//        val ticket = checkerMap[id]!!
//        val route = "${ticket.startStation}|$stationName"
//        val time = t - ticket.time
//        routeMap[route] =
//            routeMap[route]?.let { AverageContainer(it.sumOfTimes + time, it.times + 1) } ?: AverageContainer(time, 1)
//    }
//
//    fun getAverageTime(startStation: String, endStation: String): Double =
//        routeMap["$startStation|$endStation"]!!.run { sumOfTimes / times.toDouble() }
//
//    data class Ticket(val startStation: String, val time: Int)
//    data class AverageContainer(var sumOfTimes: Int, var times: Int)
//}
