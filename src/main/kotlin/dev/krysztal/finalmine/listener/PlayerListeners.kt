package dev.krysztal.finalmine.listener

import dev.krysztal.finalmine.events.PlayerJobChangeEvent
import dev.krysztal.finalmine.skill.whm.Regen
import dev.krysztal.finalmine.utils.RunnerUtils
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class PlayerListeners : Listener {
    @EventHandler
    fun onPlayerUseSkill(event: PlayerInteractEvent) {
        if (event.action.isLeftClick) return
        val mainHandMaterial = event.player.inventory.itemInMainHand.type
        val offHandMaterial = event.player.inventory.itemInOffHand.type
        val isHandAir = mainHandMaterial.isAir && offHandMaterial.isAir
        if (event.player.getCooldown(mainHandMaterial) != 0 || event.player.getCooldown(offHandMaterial) != 0 || isHandAir) return

        RunnerUtils.run {
            Arrays.stream(event.player.inventory.contents)
                .filter { obj: ItemStack? -> Objects.nonNull(obj) }
                .forEach { v: ItemStack? ->
                    event.player.setCooldown(v!!.type, 50)
                }
        }.run()
        event.player.maxHealth = 60.0
        Regen().effect(event.player)
    }

    @EventHandler
    fun onPlayerJobChange(event: PlayerJobChangeEvent) {

    }
}