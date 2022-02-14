
fun <T> printResult(actual: T, expected: T) =
    println(actual.also { if (actual == expected) print("pass ") else print("fail ")
    print("expected = $expected , actual = ")})

