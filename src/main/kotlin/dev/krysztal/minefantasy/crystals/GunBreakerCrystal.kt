package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.crystals.gauge.GaugeSlot
import dev.krysztal.minefantasy.crystals.gauge.GaugeSlots


class GunBreakerCrystal internal constructor() : Crystal() {
    object GunBreakerSlots {
        const val RoyalGuard = "Royal Guard"
        const val Cartridge = "Cartridge"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(GunBreakerCrystal.GunBreakerSlots.RoyalGuard, GaugeSlot.build {
                name = GunBreakerCrystal.GunBreakerSlots.RoyalGuard
                max = 1
            }),
            Pair(GunBreakerCrystal.GunBreakerSlots.Cartridge, GaugeSlot.build {
                name = GunBreakerCrystal.GunBreakerSlots.Cartridge
                max = 3
            })

        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = GunBreakerCrystal.Companion.GAUGE_ID
    }

    companion object {
        const val GAUGE_ID = "Cartridge Slots"
    }
}