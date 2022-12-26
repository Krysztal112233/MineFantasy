package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.foundation.skill.aoe.Damage
import org.bukkit.entity.Player

/**
 * 苦难之心
 */
class AfflatusMisery : Damage(mana = 0, distance = 25, radius = 5) {
    override fun effect(player: Player) {
        super.effect(player)
    }
}