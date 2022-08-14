package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.AreaOfEffect
import dev.krysztal.minefantasy.utils.FilterUtils
import dev.krysztal.minefantasy.utils.ParticleUtils
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