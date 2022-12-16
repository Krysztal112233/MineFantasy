package dev.krysztal.minefantasy.foundation.skills.direct

import dev.krysztal.minefantasy.foundation.skills.DirectDamage
import dev.krysztal.minefantasy.foundation.skills.SkillType

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
)