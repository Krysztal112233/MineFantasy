package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.AreaOfEffect
import dev.krysztal.finalmine.utils.FilterUtils
import dev.krysztal.finalmine.utils.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

/**
 * 神圣
 */
class Holy : AreaOfEffect() {
    init {
        super.radius = 15
        super.addApplyFilters(FilterUtils.forMonster)
        super.setEffect { entity: LivingEntity?, player: Player? ->
            ParticleUtils.spawnHurtParticle(entity)
            entity?.damage(3.0, player)
        }
    }
}