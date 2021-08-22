package programmers.p3


fun main() {
    println(solution(arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"), arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"), arrayOf("young", "john", "tod", "emily", "mary"), intArrayOf(12, 4, 2, 5, 10)).joinToString())
}


private fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
    var enrollMap = HashMap<String, String>()
    var resultMap = LinkedHashMap<String, Int>()
    enroll.forEachIndexed { index, person ->
        enrollMap[person] = referral[index]
        resultMap[person] = 0
    }
    for (index in seller.indices) {
        var currentSeller = seller[index]
        var currentAmount = amount[index] * 100
        var referral = enrollMap[currentSeller]
        var amountForReferral = currentAmount / 10
        var amountForSeller = currentAmount - amountForReferral
        resultMap[currentSeller] = resultMap.getValue(currentSeller) + amountForSeller
        while (enrollMap[currentSeller] != "-" && amountForReferral != 0) {
            currentSeller = referral!!
            currentAmount = amountForReferral
            referral = enrollMap[currentSeller]
            amountForReferral = currentAmount / 10
            amountForSeller = currentAmount - amountForReferral
            resultMap[currentSeller] = resultMap.getValue(currentSeller) + amountForSeller
        }
    }
    return resultMap.values.toIntArray()
}