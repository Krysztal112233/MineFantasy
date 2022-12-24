package dev.krysztal.minefantasy.foundation

import org.bukkit.Bukkit
import org.bukkit.entity.LivingEntity
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

fun LivingEntity?.addPotionEffect(effectType: PotionEffectType?, duration: Int, amplifier: Int) {
    if (this?.hasPotionEffect(effectType!!) == true) {
        effectType?.let { this.removePotionEffect(it) }
    }

    effectType?.let { PotionEffect(it, duration, amplifier, false, true, true) }
        ?.let { this?.addPotionEffect(it) }
}


fun Double.toTickDuration(): Double {
    return Bukkit.getServer().tickTimes.last().toInt() * this
}

fun BukkitRunner.toRunner(): BukkitRunnable {
    return object : BukkitRunnable() {
        override fun run() {
            this@toRunner.run { }
        }
    }
}

