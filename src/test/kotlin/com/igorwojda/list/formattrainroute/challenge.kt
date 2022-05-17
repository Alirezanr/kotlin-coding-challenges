package com.igorwojda.list.formattrainroute

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun formatTrainRoute(stations: List<String>): String {
    val prefixString = "Train is calling at"

    return when (stations.size) {
        1 -> {
            "$prefixString ${stations.first()}"
        }
        2 -> {
            "$prefixString ${stations.first()} and ${stations.last()}"
        }
        else -> {
            val stationNames = java.lang.StringBuilder()

            stations.forEachIndexed { index, station ->
                if (index < stations.size-1) {
                    stationNames.append(station)
                    if(index+2 < stations.size){
                        stationNames.append(", ")
                    }
                } else if (index == stations.size - 1) {
                    stationNames.append(" and $station")
                }
            }

            "$prefixString $stationNames"
        }
    }

}

private class Test {
    @Test
    fun `formatTrainRoute list "Luton"`() {
        formatTrainRoute(listOf("Luton")) shouldBeEqualTo "Train is calling at Luton"
    }

    @Test
    fun `formatTrainRoute list "Luton", "Harpenden"`() {
        formatTrainRoute(listOf("Luton", "Harpenden")) shouldBeEqualTo "Train is calling at Luton and Harpenden"
    }

    @Test
    fun `formatTrainRoute list "Luton", "Harpenden", "London"`() {
        val list = listOf("Luton", "Harpenden", "London")
        formatTrainRoute(list) shouldBeEqualTo "Train is calling at Luton, Harpenden and London"
    }

    @Test
    fun `formatTrainRoute list "Luton", "Harpenden", "St Albans", "London"`() {
        val list = listOf("Luton", "Harpenden", "St Albans", "London")
        formatTrainRoute(list) shouldBeEqualTo "Train is calling at Luton, Harpenden, St Albans and London"
    }
}
