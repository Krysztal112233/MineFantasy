package dev.krysztal.finalmine.events

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerJobChangeEvent : Event() {

    companion object {
        private val handlerList = HandlerList()

    }

    override fun getHandlers(): HandlerList {
        return handlerList
    }
}