package dev.krysztal.finalmine.crystals.gauge

class GaugeSlots(slots: MutableMap<String?, GaugeSlot?>) : LinkedHashMap<String?, GaugeSlot?>(slots) {
    var slotCount: Int

    init {
        slotCount = slots.size
    }
}