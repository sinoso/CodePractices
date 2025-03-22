package leetcode.medium

fun main() {

}

private fun findAllRecipes(
    recipes: Array<String>,
    ingredients: List<List<String>>,
    supplies: Array<String>
): List<String> {
    val waitingMap = HashMap<String, HashSet<String>>()
    val progressMap = HashMap<String, HashSet<String>>()

    fun removeWaiting(supply: String) {
        val waitingFoods = waitingMap[supply] ?: return
        for (food in waitingFoods) {
            val ingredientSet = progressMap[food] ?: continue
            ingredientSet.remove(supply)
            if (ingredientSet.isEmpty()){
                removeWaiting(food)
            }
        }
    }
    for (i in recipes.indices) {
        val name = recipes[i]
        val ingredientList = ingredients[i]
        progressMap[name] = ingredientList.toHashSet()

        for (s in ingredientList) {
            val set = (waitingMap[s] ?: HashSet())
            set.add(name)
            waitingMap[s] = set
        }
    }
    for (s in supplies) {
        removeWaiting(s)
    }
    val answerList = mutableListOf<String>()
    for ((k,v) in progressMap){
        if (v.size==0)
        answerList.add(k)
    }

    return answerList
}

//waiting -> 재료 - 음식 123
//progress -> 음식 - 재료 123

// 각  매핑을 함.
// 제공된 것을들 순차로 돌림
//waiting에서 재료를 제거!
//progress에서 해당 음식들set에서 재료 제거
// 근데 progress에서 완료 된 음식이 있다?-> 근데 해당 음식이 재료다? -> waiting에서 재료를 제거하는것을 반복!
