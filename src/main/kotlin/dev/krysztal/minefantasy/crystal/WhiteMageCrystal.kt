package dev.krysztal.minefantasy.crystal

import dev.krysztal.minefantasy.foundation.GaugeSlot
import dev.krysztal.minefantasy.foundation.GaugeSlots

class WhiteMageCrystal : Crystal(
    gaugeName = "Secret of Lily",
    gaugeSlots = GaugeSlots(
        linkedMapOf(
            Pair(
                "Lily", GaugeSlot.build
                {
                    name = "Lily"
                    max = 3
                }),
            Pair(
                "Blood Lily", GaugeSlot.build
                {
                    name = "Blood Lily"
                    max = 3
                })
        )
    )
)