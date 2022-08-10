package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.AreaOfEffect
import dev.krysztal.finalmine.utils.FilterUtils
import dev.krysztal.finalmine.utils.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

class CureIII : AreaOfEffect() {
    init {
        super.radius = 20
        super.addApplyFilters(FilterUtils.forParty)
        super.setEffect { entity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(entity)
            entity!!.health = (entity.health + 14).coerceAtMost(entity.maxHealth)
        }
    }
}