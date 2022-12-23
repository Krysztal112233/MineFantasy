package dev.krysztal.minefantasy.crystal

import dev.krysztal.minefantasy.foundation.GaugeSlot
import dev.krysztal.minefantasy.foundation.GaugeSlots

class EmptyCrystal : Crystal(
    gaugeName = "Empty", gaugeSlots = GaugeSlots(
        linkedMapOf(
            Pair(
                "Empty Crystal",
                GaugeSlot.build {
                    name = "Empty Slots"
                    max = 1
                })
        )
    )
)