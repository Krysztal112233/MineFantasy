package dev.krysztal.minefantasy.foundation.skill.aoe

import dev.krysztal.minefantasy.foundation.addPotionEffect
import dev.krysztal.minefantasy.foundation.decMana
import dev.krysztal.minefantasy.foundation.playerFilter
import dev.krysztal.minefantasy.foundation.toTickDuration
import dev.krysztal.minefantasy.foundation.util.ParticleUtils
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
    ) {
    override fun effect(player: Player) {
        super.effect(player)
        player.decMana(this.mana)
    }
}