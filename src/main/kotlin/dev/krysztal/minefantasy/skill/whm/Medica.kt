package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.AreaOfEffect
import dev.krysztal.minefantasy.utils.FilterUtils
import dev.krysztal.minefantasy.utils.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

class Medica : AreaOfEffect() {
    init {
        super.radius = 15
        super.addApplyFilters(FilterUtils.forParty)
        super.setEffect { entity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(entity)
            entity!!.health = (entity.health + 8).coerceAtMost(entity.maxHealth)
        }
    }
}