package dev.krysztal.finalmine.interfaces

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

fun interface IApplyEffect {
    fun f(livingEntities: LivingEntity?, player: Player?)
}