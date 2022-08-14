package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.DirectDamage
import dev.krysztal.minefantasy.utils.FilterUtils
import dev.krysztal.minefantasy.utils.ParticleUtils
import dev.krysztal.minefantasy.utils.PotionUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

class Regen : DirectDamage() {
    init {
        super.maxDistance = 30
        super.addApplyFilters(FilterUtils.forPlayer)
        super.setEffect { entity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(entity)
            entity!!.health = (entity.health + 4).coerceAtMost(entity.maxHealth)
            PotionUtils.add(entity, PotionEffectType.REGENERATION, 20 * 18, 2)
        }
    }
}