package dev.krysztal.minefantasy.foundation.skill.aoe

import dev.krysztal.minefantasy.foundation.decMana
import dev.krysztal.minefantasy.foundation.monsterFilter
import dev.krysztal.minefantasy.foundation.skill.SkillType
import dev.krysztal.minefantasy.foundation.toTickDuration
import dev.krysztal.minefantasy.foundation.util.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

open class Damage(
    mana: Int = 400,
    radius: Int = 8,
    distance: Int = 0,
    coolDown: Double = 2.5.toTickDuration(),
    damage: Double = 8.0,
    skillType: SkillType = SkillType.Magic
) : AreaOfEffect(
    radius = radius,
    filter = monsterFilter,
    mana = mana,
    coolDown = coolDown,
    skillType = skillType,
    distance = distance,
    effect = { entity: LivingEntity?, player: Player? ->
        ParticleUtils.spawnHurtParticle(entity)
        entity?.damage(damage, player)
    }
) {
    override fun effect(player: Player) {
        super.effect(player)
        player.decMana(this.mana)
    }
}