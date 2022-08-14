package dev.krysztal.minefantasy.utils

import dev.krysztal.minefantasy.interfaces.IRunner
import org.bukkit.scheduler.BukkitRunnable

object RunnerUtils {
    fun run(runner: IRunner): BukkitRunnable {
        return object : BukkitRunnable() {
            override fun run() {
                runner.run()
            }
        }
    }
}