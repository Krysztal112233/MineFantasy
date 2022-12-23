package dev.krysztal.minefantasy.foundation.skill.direct

import dev.krysztal.minefantasy.foundation.playerFilter
import dev.krysztal.minefantasy.foundation.skill.DirectDamage
import dev.krysztal.minefantasy.foundation.skill.SkillType
import dev.krysztal.minefantasy.foundation.toTickDuration
import dev.krysztal.minefantasy.foundation.util.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

open class Heal(
    heal: Int = 10,
    mana: Int = 800,
    distance: Int = 15,
    skillType: SkillType = SkillType.Magic,
    coolDown: Double = 2.5.toTickDuration()
) : DirectDamage(
    distance = distance,
    filter = playerFilter,
    mana = mana,
    skillType = skillType,
    coolDown = coolDown,
    effect = { entity: LivingEntity?, _: Player? ->
        ParticleUtils.spawnCureParticle(entity)
        entity!!.health = (entity.health + heal).coerceAtMost(entity.maxHealth)
    }
)