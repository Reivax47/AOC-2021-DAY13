import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Generate " first page " from the input
 */
fun giveMePage1(input: List<String>): Array<Array<Int>> {
    var tableau = arrayOf<Array<Int>>()
    var max_x = 0
    var max_y = 0
    input.filter { it.contains(',') }.forEach {
        val coord = it.split(',')
        val x = coord[0].toInt()
        val y = coord[1].toInt()
        max_x = if (max_x < x) x else max_x
        max_y = if (max_y < y) y else max_y
    }

    for (i in 0..max_y) {
        var une_ligne = arrayOf<Int>()
        for (i in 0..max_x) {
            une_ligne += 0
        }
        tableau += une_ligne
    }

    input.filter { it.contains(',') }.forEach {
        val coord = it.split(',')
        val x = coord[0].toInt()
        val y = coord[1].toInt()
        tableau[y][x] = 1
    }
    return tableau
}

/**
 *
 */
fun howManyDotsVisible(tableau: Array<Array<Int>>): Int {

    var reponse = 0
    tableau.forEach { it_ligne ->
        reponse += it_ligne.filter { it == 1 }.size
    }
    return reponse
}

fun foldIt(tableau: Array<Array<Int>>, x: Int, y: Int): Array<Array<Int>> {
    var folded = arrayOf<Array<Int>>()
    if (x > 0) {

        var max_y = tableau.size - 1
        var max_x = x - 1
        for (i in 0..max_y) {
            var une_ligne = arrayOf<Int>()
            for (i in 0..max_x) {
                une_ligne += 0
            }
            folded += une_ligne
        }

        for (posY in 0 until tableau.size) {
            for (posX in 0 until x) {
                folded[posY][posX] =
                    if (tableau[posY][posX] == 1 || tableau[posY][tableau[posY].size - 1 - posX] == 1) 1 else 0
            }
        }
    } else {

        var max_y = y - 1
        var max_x = tableau[0].size - 1
        for (i in 0..max_y) {
            var une_ligne = arrayOf<Int>()
            for (i in 0..max_x) {
                une_ligne += 0
            }
            folded += une_ligne
        }
        for (posY in 0 until y) {
            for (posX in 0 until tableau[0].size) {
                folded[posY][posX] =
                    if (tableau[posY][posX] == 1 || tableau[tableau.size - 1 - posY][posX] == 1) 1 else 0
            }
        }
    }

    return folded
}