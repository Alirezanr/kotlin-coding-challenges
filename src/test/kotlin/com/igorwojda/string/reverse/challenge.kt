package com.igorwojda.string.reverse

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun reverse(str: String): String {
    var reversedStr = ""
    for (i in str.lastIndex downTo 0) {
        reversedStr += str[i]
    }
    return reversedStr
}

private class Test {
    @Test
    fun `Reverse of "abcd" is "dcba"`() {
        reverse("abcd") shouldBeEqualTo "dcba"
    }

    @Test
    fun `Reverse of "aabbccdd" is "ddccbbaa"`() {
        reverse("aabbccdd") shouldBeEqualTo "ddccbbaa"
    }
}
