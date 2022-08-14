package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.AreaOfEffect
import dev.krysztal.minefantasy.utils.FilterUtils
import dev.krysztal.minefantasy.utils.ParticleUtils
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