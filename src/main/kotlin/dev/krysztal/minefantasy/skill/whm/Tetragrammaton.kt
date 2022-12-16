package dev.krysztal.minefantasy.skill.whm

import dev.krysztal.minefantasy.foundation.skills.SkillType
import dev.krysztal.minefantasy.foundation.skills.direct.Heal
import dev.krysztal.minefantasy.foundation.toTickDuration

/**
 * 神名
 */
class Tetragrammaton : Heal(
    distance = 30,
    heal = 15,
    skillType = SkillType.Ability,
    coolDown = 60.0.toTickDuration()
)