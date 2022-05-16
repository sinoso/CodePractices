package leetcode.easy

fun main() {

}

private fun destCity(paths: List<List<String>>): String {
   val set = paths.map { (start)-> start}.toHashSet()
    return paths.find { (_,end)-> set.add(end) }!![1]
}

private fun destCity2(paths: List<List<String>>): String {
    val map: MutableMap<String, Int> = HashMap()
    paths.forEach { (start, end) ->
        map[start] = map.getOrDefault(start, 0) - 1
        map[end] = map.getOrDefault(end, 0) + 1
    }
    return map.entries.find { it.value==1 }!!.key
}

private fun destCity3(paths: List<List<String>>): String {
    val startMap: MutableMap<String, Int> = HashMap()
    val endMap: MutableMap<String, Int> = HashMap()
    paths.forEach { (start, end) ->
        startMap[start] = startMap.getOrDefault(start, 0) + 1
        endMap[end] = endMap.getOrDefault(end, 0) + 1
    }
    startMap.forEach {
        endMap[it.key]?: return@forEach
        if(startMap[it.key]==endMap[it.key]){
            endMap.remove(it.key)
        }else{
            return it.key
        }
    }
    return endMap.keys.first()
}
