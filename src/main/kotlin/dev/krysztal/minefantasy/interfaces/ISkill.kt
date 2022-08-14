package dev.krysztal.minefantasy.interfaces

import dev.krysztal.minefantasy.skill.common.SkillType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

interface ISkill {
    fun effect(player: Player)
    fun addApplyFilters(vararg f: (entity: LivingEntity?, player: Player?) -> Boolean)
    fun addApplyFilters(vararg f: IApplyFilter)
    fun setEffect(
        f: (entity: LivingEntity?, player: Player?) -> Unit
    )

    val skillType: SkillType?
        get() = SkillType.Magic
}