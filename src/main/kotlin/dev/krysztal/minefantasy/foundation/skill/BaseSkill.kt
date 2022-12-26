package dev.krysztal.minefantasy.foundation.skill

import dev.krysztal.minefantasy.foundation.EffectApplier
import dev.krysztal.minefantasy.foundation.EntityFilter
import org.bukkit.entity.Player

abstract class BaseSkill(
    open val filter: EntityFilter = { _, _ -> true },
    open val mana: Int = 0,
    open val distance: Int = 15,
    open val radius: Int = 8,
    open val effect: EffectApplier = { _, _ -> },
    open val skillType: SkillType = SkillType.Magic,
    open val coolDown: Double = 2.5 * 20,
    open val cdType: CoolDownType = CoolDownType.Generic,
) {
    abstract fun effect(player: Player)
}