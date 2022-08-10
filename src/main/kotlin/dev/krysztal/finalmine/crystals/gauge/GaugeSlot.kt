package dev.krysztal.finalmine.crystals.gauge


class GaugeSlot {


    var name: String = "null"
    var max = 0
    var min = 0

    var current = 0
        set(value) {
            if (value >= min) field = value
        }

    private constructor(builder: Builder) {
        this.name = builder.name
        this.max = builder.max
        this.min = builder.min
        this.current = builder.current
    }

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {
        var name: String = "null"
        var max = 0
        var min = 0
        var current = 0

        fun build() = GaugeSlot(this)
    }
}