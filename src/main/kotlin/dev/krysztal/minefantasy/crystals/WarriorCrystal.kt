package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.foundation.GaugeSlot
import dev.krysztal.minefantasy.foundation.GaugeSlots

class WarriorCrystal : Crystal(
    gaugeName = "The Beast",
    gaugeSlots = GaugeSlots(
        linkedMapOf(
            Pair("Defiance", GaugeSlot.build {
                name = "Defiance"
                max = 1
            }),
            Pair("Beast Gauge", GaugeSlot.build {
                name = "Beast Gauge"
                max = 100
            })
        )
    )
)