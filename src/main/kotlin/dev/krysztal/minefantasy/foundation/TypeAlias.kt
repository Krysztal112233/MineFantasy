package dev.krysztal.minefantasy.foundation

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

typealias EffectApplier = (LivingEntity?, Player) -> Unit
typealias EntitiesFilter = (LivingEntity?, Player) -> Boolean
typealias BukkitRunner = () -> Unit