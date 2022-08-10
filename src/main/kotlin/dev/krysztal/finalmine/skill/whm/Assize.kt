package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.AreaOfEffect
import dev.krysztal.finalmine.utils.FilterUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

class Assize : AreaOfEffect() {
    override fun effect(player: Player) {
        AssizeDamage().effect(player)
        AssizeHeal().effect(player)
    }
}

class AssizeDamage : AreaOfEffect() {
    init {
        super.radius = 15
        super.addApplyFilters(FilterUtils.forMonster)
        super.setEffect { entity: LivingEntity?, player: Player? ->
            entity?.damage(8.0, player)
        }
    }
}


class AssizeHeal : AreaOfEffect() {
    override fun effect(player: Player) {
        Medica().effect(player)
    }
}