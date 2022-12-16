package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.foundation.GaugeSlot
import dev.krysztal.minefantasy.foundation.GaugeSlots


class GunBreakerCrystal : Crystal(
    gaugeName = "Cartridge Slots",
    gaugeSlots = GaugeSlots(
        linkedMapOf(
            Pair("Royal Guard", GaugeSlot.build {
                name = "Royal Guard"
                max = 1
            }),
            Pair("Cartridge", GaugeSlot.build {
                name = "Cartridge"
                max = 3
            })

        )
    )
)