package dev.krysztal.minefantasy.foundation.skills.aoe

import dev.krysztal.minefantasy.foundation.addPotionEffect
import dev.krysztal.minefantasy.foundation.skills.AreaOfEffect
import dev.krysztal.minefantasy.foundation.toTickDuration
import dev.krysztal.minefantasy.foundation.utils.ParticleUtils
import dev.krysztal.minefantasy.foundation.playerFilter
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

class HealOverTick(
    duration: Int = 20 * 15,
    amplifier: Int,
    heal: Int = 4,
    distance: Int = 15,
    radius: Int = 8,
    mana: Int = 1200,
    coolDown: Double = 2.5.toTickDuration()
) :
    AreaOfEffect(
        distance = distance,
        radius = radius,
        filter = playerFilter,
        mana = mana,
        coolDown = coolDown,
        effect = { livingEntity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(livingEntity)
            livingEntity!!.health = (livingEntity.health + heal).coerceAtMost(livingEntity.maxHealth)
            livingEntity.addPotionEffect(PotionEffectType.REGENERATION, duration, amplifier)
        }
    )
