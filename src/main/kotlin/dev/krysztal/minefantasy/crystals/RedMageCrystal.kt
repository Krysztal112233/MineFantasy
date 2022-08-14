package dev.krysztal.minefantasy.crystals

import dev.krysztal.minefantasy.crystals.gauge.GaugeSlot
import dev.krysztal.minefantasy.crystals.gauge.GaugeSlots

class RedMageCrystal : Crystal() {
    object RedMageSlots {
        const val BlackMana = "Black Mana"
        const val WhiteMana = "White Mana"
    }

    init {
        val s: MutableMap<String?, GaugeSlot?> = linkedMapOf(
            Pair(RedMageSlots.BlackMana, GaugeSlot.build {
                name = RedMageSlots.BlackMana
                max = 100
            }),
            Pair(RedMageSlots.WhiteMana, GaugeSlot.build {
                name = RedMageSlots.WhiteMana
                max = 100
            })

        )
        super.gaugeSlots = GaugeSlots(s)
        super.gaugeID = Companion.GAUGE_ID
    }

    companion object {
        const val GAUGE_ID = "Mana Stack"
    }
}