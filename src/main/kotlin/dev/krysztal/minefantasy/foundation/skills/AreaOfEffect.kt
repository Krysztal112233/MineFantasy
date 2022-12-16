package dev.krysztal.minefantasy.foundation.skills

import dev.krysztal.minefantasy.foundation.EffectApplier
import dev.krysztal.minefantasy.foundation.EntitiesFilter
import dev.krysztal.minefantasy.foundation.toTickDuration
import org.bukkit.entity.Player

abstract class AreaOfEffect(
    override val filter: EntitiesFilter = { _, _ -> true },
    override val mana: Int = 0,
    override val distance: Int = 15,
    override val radius: Int = 8,
    override val effect: EffectApplier = { _, _ -> },
    override val skillType: SkillType = SkillType.Magic,
    override val coolDown: Double = 2.5.toTickDuration()
) : BaseSkill(filter, mana, distance, radius, skillType = skillType, coolDown = coolDown) {


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