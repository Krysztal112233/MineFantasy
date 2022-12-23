package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.foundation.skill.direct.Heal
import org.bukkit.entity.Player

/**
 * 安慰之心
 */
class AfflatusSolace : Heal(mana = 0, distance = 25, heal = 15) {
    override fun effect(player: Player) {
        super.effect(player)
    }
}