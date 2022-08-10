package dev.krysztal.finalmine.utils

import org.bukkit.entity.LivingEntity
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object PotionUtils {
    fun add(livingEntity: LivingEntity?, type: PotionEffectType?, duration: Int, amplifier: Int) {
        if (livingEntity!!.hasPotionEffect(type!!)) {
            livingEntity.removePotionEffect(type)
        }
        livingEntity.addPotionEffect(PotionEffect(type, duration, amplifier, false, true, true))
    }
}