package Programmers.P2


fun main() {
    println(solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500)).joinToString())
}


private fun solution(genres: Array<String>, plays: IntArray): IntArray = Pair<HashMap<String, HashMap<Int, Int>>, HashMap<String, Int>>(HashMap(), HashMap()).also { genres.indices.map { i -> it.second[genres[i]] = it.second.getOrDefault(genres[i], 0) + plays[i] } }.also { genres.indices.map { i -> it.first[genres[i]] = it.first.getOrDefault(genres[i], HashMap()).also { map -> map[i] = plays[i] } } }.let { it.second.toList().sortedByDescending { secondPair -> secondPair.second }.map { secondPair -> it.first[secondPair.first]!!.toList().sortedByDescending { firstPair -> firstPair.second }.take(2).map { firstPair -> firstPair.first } }.flatMap { listToFlat -> listToFlat.toList() }.toIntArray() }
private fun solution2(genres: Array<String>, plays: IntArray): IntArray =
        Pair<HashMap<String, HashMap<Int, Int>>, HashMap<String, Int>>(HashMap(), HashMap())
                .also {
                    genres.indices.map { i ->
                        it.second[genres[i]] = it.second.getOrDefault(genres[i], 0) + plays[i]
                    }
                }
                .also {
                    genres.indices
                            .map { i ->
                                it.first[genres[i]] = it.first.getOrDefault(genres[i], HashMap())
                                        .also { map -> map[i] = plays[i] }
                            }
                }
                .let {
                    it.second
                            .toList()
                            .sortedByDescending { secondPair -> secondPair.second }
                            .map { secondPair ->
                                it.first[secondPair.first]!!
                                        .toList()
                                        .sortedByDescending { firstPair -> firstPair.second }
                                        .take(2)
                                        .map { firstPair -> firstPair.first }
                            }
                            .flatMap { listToFlat -> listToFlat.toList() }
                            .toIntArray()
                }

private fun solution3(genres: Array<String>, plays: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    var genresPlayMap = HashMap<String, Int>()
    var playsMap = HashMap<String, HashMap<Int, Int>>() //장르명 해쉬맵 안에 index(key)와 플래이(value)로 정해지는 해쉬맵 추가.
    for (i in genres.indices) {
        var genreName = genres[i]
        var play = plays[i]
        genresPlayMap.put(genreName, genresPlayMap.getOrDefault(genreName, 0) + play)
        playsMap.put(genreName, playsMap.getOrDefault(genreName, HashMap()).also { it.put(i, play) })
    }
    var genresPlayList = genresPlayMap.toList().sortedByDescending { it.second }
    for (genre in genresPlayList) {
        var genreName = genre.first
        answer.addAll(playsMap.get(genreName)!!.toList().sortedByDescending { it.second }.take(2).map { it.first })
    }
    return answer.toIntArray()
}