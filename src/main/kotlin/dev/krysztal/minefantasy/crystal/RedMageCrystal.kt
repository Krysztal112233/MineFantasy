package dev.krysztal.minefantasy.crystal

import dev.krysztal.minefantasy.foundation.GaugeSlot
import dev.krysztal.minefantasy.foundation.GaugeSlots


class RedMageCrystal : Crystal(
    gaugeName = "Mana Stack",
    gaugeSlots = GaugeSlots(
        linkedMapOf(
            Pair("Black Mana", GaugeSlot.build {
                name = "Black Mana"
                max = 100
            }),
            Pair("White Mana", GaugeSlot.build {
                name = "White Mana"
                max = 100
            })
        )
    )
)