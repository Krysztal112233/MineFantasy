package dev.krysztal.minefantasy.foundation.skill.aoe

import dev.krysztal.minefantasy.foundation.EffectApplier
import dev.krysztal.minefantasy.foundation.EntityFilter
import dev.krysztal.minefantasy.foundation.decMana
import dev.krysztal.minefantasy.foundation.skill.BaseSkill
import dev.krysztal.minefantasy.foundation.skill.CoolDownType
import dev.krysztal.minefantasy.foundation.skill.SkillType
import dev.krysztal.minefantasy.foundation.toTickDuration
import org.bukkit.entity.Player

abstract class AreaOfEffect(
    override val filter: EntityFilter = { _, _ -> true },
    override val mana: Int = 0,
    override val distance: Int = 15,
    override val radius: Int = 8,
    override val effect: EffectApplier = { _, _ -> },
    override val skillType: SkillType = SkillType.Magic,
    override val coolDown: Double = 2.5.toTickDuration(),
    override val cdType: CoolDownType = CoolDownType.Generic
) : BaseSkill(filter, mana, distance, radius, skillType = skillType, coolDown = coolDown, cdType = cdType) {

    override fun effect(player: Player) {
        var location = player.location
        // 判断距离
        if (player.location.distance(location) > this.distance) location = player.location
        val finalLocation = location

        // 扫描目标
        var entityStream = finalLocation.getNearbyLivingEntities(radius.toDouble()).stream()

        // 应用过滤器
        entityStream = entityStream.filter { t -> this.filter(t, player) }
        entityStream.forEach { v -> effect(v, player) }

    }
}