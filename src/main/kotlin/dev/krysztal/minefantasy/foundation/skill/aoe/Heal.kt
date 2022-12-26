package dev.krysztal.minefantasy.foundation.skill.aoe

import dev.krysztal.minefantasy.foundation.decMana
import dev.krysztal.minefantasy.foundation.partyFilter
import dev.krysztal.minefantasy.foundation.util.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

open class Heal(
    distance: Int = 15,
    radius: Int = 15,
    heal: Int = 15,
    mana: Int = 800
) :
    AreaOfEffect(
        radius = radius,
        distance = distance,
        filter = partyFilter,
        mana = mana,
        effect = { entity: LivingEntity?, _: Player? ->
            ParticleUtils.spawnCureParticle(entity)
            entity!!.health = (entity.health + heal).coerceAtMost(entity.maxHealth)
        }
    ) {
    override fun effect(player: Player) {
        super.effect(player)
        player.decMana(this.mana)
    }
}