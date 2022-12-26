package dev.krysztal.minefantasy.foundation.skill.direct

import dev.krysztal.minefantasy.foundation.decMana
import dev.krysztal.minefantasy.foundation.skill.SkillType
import org.bukkit.entity.Player

open class Damage(
    mana: Int,
    distance: Int = 25,
    skillType: SkillType = SkillType.Magic,
    damage: Int
) : DirectDamage(
    distance = distance,
    mana = mana,
    skillType = skillType,
    effect = { livingEntity, player -> livingEntity?.damage(damage.toDouble(), player) }
) {
    override fun effect(player: Player) {
        super.effect(player)
        player.decMana(this.mana)
    }
}