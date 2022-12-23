package dev.krysztal.minefantasy.crystal

import dev.krysztal.minefantasy.foundation.GaugeSlots

abstract class Crystal(
    val gaugeName: String,
    val gaugeSlots: GaugeSlots
) {

    val slotsCount: Int
        get() = gaugeSlots.size

    fun decrease(slot: String, mount: Int): Boolean {
        val now = gaugeSlots[slot]
        if (now!!.current - mount < now.min) {
            now.current = now.min
            return false
        }
        now.current -= mount
        gaugeSlots[slot] = now
        return true
    }

    fun increase(slot: String, mount: Int): Boolean {
        val now = gaugeSlots[slot]
        if (now!!.current + mount > now.max) {
            now.current = now.max
            return false
        }
        now.current += mount
        gaugeSlots[slot] = now
        return true
    }


    fun getMaxInSlot(slot: String): Int {
        return gaugeSlots[slot]!!.max
    }

    fun getCurrentInSlot(slot: String): Int {
        return gaugeSlots[slot]!!.current
    }
}