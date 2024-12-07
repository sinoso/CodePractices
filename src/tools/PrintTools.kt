package tools

 const val RED_FAIL = "\u001B[31m"
 const val GREEN_SUCCESS = "\u001B[32m";
 const val COLOR_EXIT = "\u001B[0m";

inline fun <T : Any> checkResult(expected: T, actual: T) {
    val fileName = Thread.currentThread().stackTrace[1].fileName
    println(fileName)
    val sb = StringBuilder()
    val result = expected == actual
    val resultColor = if (result) GREEN_SUCCESS else RED_FAIL
    val resultText = if (result) "SUCCESS" else "FAIL"

    sb.apply {
        append("Expected : ")
        append(expected.toString()) //todo Array?[]? [][]? [][][]?
        append("\nActual   : ")
        append(actual.toString()) //todo Array?[]? [][]? [][][]?
        append("\nResult   : ")
        sb.append(resultColor)
        sb.append(resultText)
        sb.append(COLOR_EXIT)
        sb.append("\n")
    }
    println(sb)
}

inline fun  checkResult(expected: Array<String>, actual: Array<String>) {
    val fileName = Thread.currentThread().stackTrace[1].fileName
    println(fileName)
    val sb = StringBuilder()
    val result = expected.contentEquals(actual)
    val resultColor = if (result) GREEN_SUCCESS else RED_FAIL
    val resultText = if (result) "SUCCESS" else "FAIL"

    sb.apply {
        append("Expected : ")
        append(expected.joinToString(prefix = "[", separator = ", ", postfix = "]")) //todo Array?[]? [][]? [][][]?
        append("\nActual   : ")
        append(actual.joinToString(prefix = "[", separator = ", ", postfix = "]")) //todo Array?[]? [][]? [][][]?
        append("\nResult   : ")
        sb.append(resultColor)
        sb.append(resultText)
        sb.append(COLOR_EXIT)
        sb.append("\n")
    }
    println(sb)
}
