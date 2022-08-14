package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.DirectDamage
import dev.krysztal.minefantasy.utils.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

class CureII : DirectDamage() {
    init {
        super.maxDistance = 30
        super.addApplyFilters({ livingEntity: LivingEntity?, _: Player? -> livingEntity is Player })
        super.setEffect { livingEntities: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(livingEntities)
            livingEntities!!.health = (livingEntities.health + 18).coerceAtMost(livingEntities.maxHealth)
        }
    }
}