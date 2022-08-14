package dev.krysztal.minefantasy.skill.common

import dev.krysztal.minefantasy.interfaces.IApplyFilter
import dev.krysztal.minefantasy.interfaces.ISkill
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import java.util.*

open class DirectDamage : ISkill {
    var maxDistance = 15
    var radius = 1
    var manaCost = 0
    private var applyFilters: MutableList<IApplyFilter> = ArrayList()
    private var e: (entity: LivingEntity?, player: Player?) -> Unit = { _, _ -> }

    override fun effect(player: Player) {

        // 扫描目标视线上最近的实体
        val playerLocation = player.location
        val scanResult = Optional.ofNullable(
            player.world.rayTraceEntities(
                playerLocation.set(
                    playerLocation.x, playerLocation.y + 2, playerLocation.z
                ), playerLocation.direction, maxDistance.toDouble()
            )
        )

        // 如果没有目标，则把目标替换成自己
        val entity =
            if (scanResult.isPresent
                && scanResult.get().hitEntity != null
                && scanResult.get().hitEntity is LivingEntity
            ) scanResult.get().hitEntity else player

        // 判断所有过滤条件
        for (f in applyFilters) {
            if (!f.f(entity as LivingEntity?, player)) return
        }

        e(entity as LivingEntity, player)

    }

    override fun addApplyFilters(vararg f: IApplyFilter) {
        f.forEach { v -> this.applyFilters.add(v) }
    }

    override fun addApplyFilters(vararg f: (entity: LivingEntity?, player: Player?) -> Boolean) {
        f.forEach { v -> this.applyFilters.add(v) }
    }

    override fun setEffect(f: (entity: LivingEntity?, player: Player?) -> Unit) {
        this.e = f;
    }
}