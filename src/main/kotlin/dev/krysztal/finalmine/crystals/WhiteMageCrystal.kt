package dev.krysztal.finalmine.crystals

import dev.krysztal.finalmine.crystals.gauge.GaugeSlot
import dev.krysztal.finalmine.crystals.gauge.GaugeSlots

class WhiteMageCrystal : Crystal() {
    object WhiteMageSlots {
        const val LILY = "Lily"
        const val BLOOD_LILY = "Blood Lily"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(WhiteMageSlots.LILY, GaugeSlot.build
            {
                name = WhiteMageSlots.LILY
                max = 3
            }),
            Pair(WhiteMageSlots.BLOOD_LILY, GaugeSlot.build
            {
                name = WhiteMageSlots.BLOOD_LILY
                max = 3

            })
        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = GAUGE_ID
    }

    companion object {
        private const val GAUGE_ID = "Secret of Lily"
    }
}