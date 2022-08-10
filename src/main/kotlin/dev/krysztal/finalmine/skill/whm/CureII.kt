package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.DirectDamage
import dev.krysztal.finalmine.utils.ParticleUtils
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