package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.skill.common.AreaOfEffect
import dev.krysztal.minefantasy.utils.FilterUtils
import dev.krysztal.minefantasy.utils.ParticleUtils
import dev.krysztal.minefantasy.utils.PotionUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

class MedicaII : AreaOfEffect() {
    init {
        super.radius = 20
        super.addApplyFilters(FilterUtils.forParty)
        super.setEffect { entity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(entity)
            entity!!.health = (entity.health + 10).coerceAtMost(entity.maxHealth)
            PotionUtils.add(entity, PotionEffectType.REGENERATION, 20 * 16, 1)
        }
    }
}