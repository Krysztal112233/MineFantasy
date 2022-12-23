package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.foundation.skill.AreaOfEffect
import dev.krysztal.minefantasy.foundation.skill.SkillType
import dev.krysztal.minefantasy.foundation.skill.aoe.Damage
import dev.krysztal.minefantasy.foundation.toTickDuration
import org.bukkit.entity.Player

class Assize : AreaOfEffect(
    skillType = SkillType.Ability,
    coolDown = 45.0.toTickDuration()
) {
    override fun effect(player: Player) {
        AssizeDamage().effect(player)
        AssizeHeal().effect(player)
    }
}

class AssizeDamage : Damage(mana = -400, radius = 15, damage = 15.0)

class AssizeHeal : Medica()
