package com.igorwojda.string.vowels

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun vowels(str: String): Int {
    var vowels = 0
    str.forEach {
        when (it) {
            'a', 'e', 'i', 'o', 'u', 'y' -> vowels++
        }
    }
    return vowels
    /*val vowelsList = listOf('a', 'e', 'i', 'o', 'u', 'y')
    return str.count {
        vowelsList.contains(it.toLowerCase())
    }*/

}

private class Test {
    @Test
    fun `"aeiouy" has 6 vovels`() {
        vowels("aeiouy") shouldBeEqualTo 6
    }

    @Test
    fun `"AEIOUY" has 6 vovels`() {
        vowels("AEIOUY") shouldBeEqualTo 6
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" has 6 vovels`() {
        vowels("abcdefghijklmnopqrstuvwxyz") shouldBeEqualTo 6
    }

    @Test
    fun `"bcadfaghijkl" has 3 vovels`() {
        vowels("bcadfaghijkl") shouldBeEqualTo 3
    }

    @Test
    fun `"bcdfghjkl" has 0 vovels`() {
        vowels("bcdfghjkl") shouldBeEqualTo 0
    }
}
