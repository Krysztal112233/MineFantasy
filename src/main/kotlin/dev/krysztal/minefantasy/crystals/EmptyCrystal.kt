package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.crystals.gauge.GaugeSlot
import dev.krysztal.minefantasy.crystals.gauge.GaugeSlots

class EmptyCrystal internal constructor() : Crystal() {
    object EmptySlot {
        const val EMPTY = "Empty"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(
                EmptySlot.EMPTY,
                GaugeSlot.build {
                    name = EmptySlot.EMPTY
                    max = 1
                })
        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = GAUGE_ID
    }

    companion object {
        const val GAUGE_ID = "Empty"
    }
}