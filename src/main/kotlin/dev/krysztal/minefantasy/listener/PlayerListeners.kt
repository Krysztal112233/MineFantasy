package dev.krysztal.minefantasy.listener

import dev.krysztal.minefantasy.foundation.events.PlayerJobChangeEvent
import dev.krysztal.minefantasy.foundation.toRunner
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import java.util.*

class PlayerListeners : Listener {
    @EventHandler
    fun onPlayerUseSkill(event: PlayerInteractEvent) {
        if (event.action.isLeftClick) return

        val mainHandMaterial = event.player.inventory.itemInMainHand.type
        val offHandMaterial = event.player.inventory.itemInOffHand.type
        val isAir = mainHandMaterial.isAir && offHandMaterial.isAir
        if (event.player.getCooldown(mainHandMaterial) != 0
            || event.player.getCooldown(offHandMaterial) != 0
            || isAir
        ) return

        {
            Arrays.stream(event.player.inventory.contents)
                .filter { Objects.nonNull(it) }
                .forEach { event.player.setCooldown(it!!.type, 50) }
        }.toRunner().run()

    }

    @EventHandler
    fun onPlayerJobChange(event: PlayerJobChangeEvent) {

    }
}