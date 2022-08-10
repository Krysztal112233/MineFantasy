package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.DirectDamage
import dev.krysztal.finalmine.utils.FilterUtils
import dev.krysztal.finalmine.utils.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

open class Cure : DirectDamage() {
    init {
        super.maxDistance = 30
        super.addApplyFilters(FilterUtils.forPlayer)
        super.setEffect() { entity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(entity)
            entity!!.health = (entity.health + 10).coerceAtMost(entity.maxHealth)
        }
    }
}