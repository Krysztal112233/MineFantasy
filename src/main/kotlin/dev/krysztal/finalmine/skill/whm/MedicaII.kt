package dev.krysztal.finalmine.skill.whm

import dev.krysztal.finalmine.skill.common.AreaOfEffect
import dev.krysztal.finalmine.utils.FilterUtils
import dev.krysztal.finalmine.utils.ParticleUtils
import dev.krysztal.finalmine.utils.PotionUtils
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