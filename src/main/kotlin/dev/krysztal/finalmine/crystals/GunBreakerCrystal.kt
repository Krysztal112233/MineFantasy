package dev.krysztal.finalmine.crystals

import dev.krysztal.finalmine.crystals.gauge.GaugeSlot
import dev.krysztal.finalmine.crystals.gauge.GaugeSlots

class GunBreakerCrystal internal constructor() : Crystal() {
    object GunBreakerSlots {
        const val RoyalGuard = "Royal Guard"
        const val Cartridge = "Cartridge"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(GunBreakerSlots.RoyalGuard, GaugeSlot.build {
                name = GunBreakerSlots.RoyalGuard
                max = 1
            }),
            Pair(GunBreakerSlots.Cartridge, GaugeSlot.build {
                name = GunBreakerSlots.Cartridge
                max = 3
            })

        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = GAUGE_ID
    }

    companion object {
        const val GAUGE_ID = "Cartridge Slots"
    }
}