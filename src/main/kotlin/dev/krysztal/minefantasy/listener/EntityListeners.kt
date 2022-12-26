package dev.krysztal.minefantasy.listener

import dev.krysztal.minefantasy.foundation.toEnemy
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class EntityListeners : Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    fun onEntitySpawn(event: EntitySpawnEvent?) {
        event?.entity?.toEnemy()
    }
}