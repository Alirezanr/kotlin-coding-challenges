package com.igorwojda.string.ispalindrome.permutation

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isPermutationPalindrome(str: String): Boolean {

    //save the count of every character in the string.
    val charsWithCounts = HashMap<Char, Int>()
    str.forEachIndexed { index, c ->
        charsWithCounts[c] = str.count { it == c }
    }
    return charsWithCounts.count {
        it.value == 1
    } <= 1
}


private class Test {
    @Test
    fun `"gikig" is a palindrome`() {
        isPermutationPalindrome("gikig") shouldBeEqualTo true
    }

    @Test
    fun `"ookvk" is a palindrome`() {
        isPermutationPalindrome("ookvk") shouldBeEqualTo true
    }

    @Test
    fun `"sows" is not a palindrome`() {
        isPermutationPalindrome("sows") shouldBeEqualTo false
    }

    @Test
    fun `"tami" is not a palindrome`() {
        isPermutationPalindrome("tami") shouldBeEqualTo false
    }
}
