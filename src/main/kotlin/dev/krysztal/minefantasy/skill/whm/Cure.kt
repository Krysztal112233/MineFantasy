package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.DirectDamage
import dev.krysztal.minefantasy.utils.FilterUtils
import dev.krysztal.minefantasy.utils.ParticleUtils
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