fun main() {
    fun part1(input: List<String>): Int {

        var pageOne = giveMePage1(input)
        val first_fold = input.filter { it.contains("fold") }.first().split(' ').last().split('=')

        if (first_fold[0] == "y") {
            pageOne = foldIt(pageOne, 0, first_fold[1].toInt())
        } else {
            pageOne = foldIt(pageOne, first_fold[1].toInt(), 0)
        }
        return howManyDotsVisible(pageOne)
    }

    fun part2(input: List<String>): Array<Array<Int>> {
        var pageOne = giveMePage1(input)
        input.filter { it.contains("fold") }.forEach { it_fold ->
            val first_fold = it_fold.split(' ').last().split('=')
            if (first_fold[0] == "y") {
                pageOne = foldIt(pageOne, 0, first_fold[1].toInt())
            } else {
                pageOne = foldIt(pageOne, first_fold[1].toInt(), 0)
            }
        }
        return pageOne
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day13_test")
    check(part1(testInput) == 17)
    val testResult = part2(testInput)
    testResult.forEach { it_ligne ->
        it_ligne.forEach {
            if (it ==0) {
                print('.')
            } else {
                print('#')
            }
        }
        println("")

    }
    val input = readInput("Day13")
    val result = part2(input)
    result.forEach { it_ligne ->
        it_ligne.forEach {
            if (it ==0) {
                print('.')
            } else {
                print('#')
            }
        }
        println("")

    }
}
