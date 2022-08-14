package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.crystals.gauge.GaugeSlot
import dev.krysztal.minefantasy.crystals.gauge.GaugeSlots

class WarriorCrystal : Crystal() {
    object WarriorSlots {
        const val Defiance = "Defiance"
        const val BeastGauge = "Beast Gauge"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(WarriorSlots.Defiance, GaugeSlot.build {
                name = WarriorSlots.Defiance
                max = 1
            }),
            Pair(WarriorSlots.BeastGauge, GaugeSlot.build {
                name = WarriorSlots.BeastGauge
                max = 100
            })
        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = Companion.GAUGE_ID
    }

    companion object {
        private const val GAUGE_ID = "The Beast"
    }
}