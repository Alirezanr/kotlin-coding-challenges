package com.igorwojda.string.longestword

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun longestWord(str: String): String {
    var finalString: String = ""
    val split = str.split(" ")
    split.forEach {
        if (it.length > finalString.length)
            finalString = it
    }
    val a = buildString {
        finalString.forEach {
            append(if (it.isLetter()) it else " ")
        }
    }

    finalString = ""

    a.split(" ").filter {
        it.isNotBlank()
    }.forEach {
        if(it.length > finalString.length)
            finalString = it
    }

    return finalString
}

private class Test {
    @Test
    fun `"flower" return "flower"`() {
        longestWord("flower") shouldBeEqualTo "flower"
    }

    @Test
    fun `"flower is growing fast" return "growing"`() {
        longestWord("flower is growing fast") shouldBeEqualTo "growing"
    }

    @Test
    fun `"This is my jeep" return "jeep"`() {
        longestWord("This is my jeep") shouldBeEqualTo "This"
    }

    @Test
    fun `"Home!@#&sweet home" return "sweet"`() {
        longestWord("Home!@&#sweet home") shouldBeEqualTo "sweet"
    }
}
