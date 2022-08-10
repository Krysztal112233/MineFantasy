package dev.krysztal.finalmine.skill.common

import dev.krysztal.finalmine.interfaces.IApplyFilter
import dev.krysztal.finalmine.interfaces.ISkill
import dev.krysztal.finalmine.mana.Mana
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

open class AreaOfEffect : ISkill {
    var maxDistance = 0
    var radius = 1
    var manaCost = 0
    private var applyFilters: MutableList<IApplyFilter> = ArrayList()
    private var e: (entity: LivingEntity?, player: Player?) -> Unit = { _, _ -> }

    override fun effect(player: Player) {
        var location = player.location
        if (player.location.distance(location) > maxDistance) location = player.location
        val finalLocation = location

        var s = finalLocation.getNearbyLivingEntities(radius.toDouble()).stream()
        // 应用所有过滤器
        for (f in applyFilters)
            s = s.filter { v: LivingEntity? -> f.f(v, player) }
        s.forEach { v -> e(v, player) }

        Mana.setMana(player, manaCost)
    }

    override fun addApplyFilters(vararg f: (entity: LivingEntity?, player: Player?) -> Boolean) {
        f.forEach { v -> this.applyFilters.add(v) }
    }

    override fun addApplyFilters(vararg f: IApplyFilter) {
        f.forEach { v -> this.applyFilters.add(v) }
    }

    override fun setEffect(f: (entity: LivingEntity?, player: Player?) -> Unit) {
        this.e = f;
    }

}