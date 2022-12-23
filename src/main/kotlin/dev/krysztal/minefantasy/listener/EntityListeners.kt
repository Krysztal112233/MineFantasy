package dev.krysztal.minefantasy.listener

import dev.krysztal.minefantasy.MineFantasyMain
import dev.krysztal.minefantasy.foundation.util.Constants
import org.bukkit.entity.SpawnCategory
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.metadata.FixedMetadataValue

class EntityListeners : Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    fun onEntitySpawn(event: EntitySpawnEvent?) {
        if (event?.entity?.spawnCategory == SpawnCategory.MONSTER)
            event.entity.setMetadata(
                Constants.MetadataKeys.IS_ENEMY,
                FixedMetadataValue(MineFantasyMain, true)
            )
    }
}