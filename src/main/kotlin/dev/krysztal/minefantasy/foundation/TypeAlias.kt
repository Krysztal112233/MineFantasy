package dev.krysztal.minefantasy.foundation

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

typealias EffectApplier = (LivingEntity?, Player) -> Unit
typealias EntityFilter = (LivingEntity?, Player) -> Boolean
typealias BukkitRunner = () -> Unit