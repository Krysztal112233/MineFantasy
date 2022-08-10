package dev.krysztal.finalmine.utils

import dev.krysztal.finalmine.interfaces.IRunner
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