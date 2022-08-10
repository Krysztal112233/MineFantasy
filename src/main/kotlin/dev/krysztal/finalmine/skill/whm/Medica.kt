package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.AreaOfEffect
import dev.krysztal.finalmine.utils.FilterUtils
import dev.krysztal.finalmine.utils.ParticleUtils
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