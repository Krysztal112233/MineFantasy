package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.crystals.gauge.GaugeSlot
import dev.krysztal.minefantasy.crystals.gauge.GaugeSlots

class WhiteMageCrystal : Crystal() {
    object WhiteMageSlots {
        const val LILY = "Lily"
        const val BLOOD_LILY = "Blood Lily"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(
                WhiteMageSlots.LILY, GaugeSlot.build
                {
                    name = WhiteMageSlots.LILY
                    max = 3
                }),
            Pair(
                WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY, GaugeSlot.build
                {
                    name = WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY
                    max = 3
                })
        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = WhiteMageCrystal.GAUGE_ID
    }

    companion object {
        private const val GAUGE_ID = "Secret of Lily"
    }
}