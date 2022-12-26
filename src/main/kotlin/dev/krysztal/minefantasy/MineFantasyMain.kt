package dev.krysztal.minefantasy

import dev.krysztal.minefantasy.command.ManaCommand
import dev.krysztal.minefantasy.listener.EntityListeners
import dev.krysztal.minefantasy.listener.PlayerListeners
import org.bukkit.plugin.java.JavaPlugin

object MineFantasyMain : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerListeners(), this)
        server.pluginManager.registerEvents(EntityListeners(), this)

        this.getCommand("mana")?.setExecutor(ManaCommand())
    }

    override fun onDisable() {}
}