package dev.krysztal.minefantasy.foundation.skill

import dev.krysztal.minefantasy.foundation.EffectApplier
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

abstract class DirectDamage(
    override val filter: (LivingEntity?, Player) -> Boolean = { _, _ -> true },
    override val mana: Int = 0,
    override val distance: Int = 15,
    override val radius: Int = 0,
    override val effect: EffectApplier,
    override val skillType: SkillType = SkillType.Magic,
    override val coolDown: Double = 2.5 * 20
) : BaseSkill(filter, mana, distance, radius, effect, skillType, coolDown) {

    override fun effect(player: Player) {

        // 扫描目标视线上最近的实体
        val playerLocation = player.location
        val rayTraceResult = player.world.rayTraceEntities(
            playerLocation.set(
                playerLocation.x, playerLocation.y + 2, playerLocation.z
            ), playerLocation.direction, distance.toDouble()
        )

        // 如果没有目标，则把目标替换成自己
        val entity =
            if (rayTraceResult?.hitEntity != null && rayTraceResult.hitEntity is LivingEntity) rayTraceResult.hitEntity else player

        // 判断过滤条件
        if (!filter(entity as LivingEntity?, player)) return

        // 应用效果
        effect(entity as LivingEntity, player)
    }
}