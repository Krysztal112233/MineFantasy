package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.foundation.skill.AreaOfEffect
import dev.krysztal.minefantasy.foundation.skill.SkillType
import dev.krysztal.minefantasy.foundation.util.ParticleUtils
import dev.krysztal.minefantasy.foundation.addPotionEffect
import dev.krysztal.minefantasy.foundation.partyFilter
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType


class MedicaII : AreaOfEffect(
    radius = 20,
    filter = partyFilter,
    skillType = SkillType.Magic,
    effect = { entity: LivingEntity?, _: Player? ->
        ParticleUtils.spawnCureParticle(entity)
        entity!!.health = (entity.health + 10).coerceAtMost(entity.maxHealth)
        entity.addPotionEffect(PotionEffectType.REGENERATION, 20 * 16, 1)
    })