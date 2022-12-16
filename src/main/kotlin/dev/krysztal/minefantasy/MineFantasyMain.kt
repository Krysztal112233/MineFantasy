package dev.krysztal.minefantasy

import dev.krysztal.minefantasy.listener.EntityListeners
import dev.krysztal.minefantasy.listener.PlayerListeners
import org.bukkit.plugin.java.JavaPlugin

object MineFantasyMain : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerListeners(), this)
        server.pluginManager.registerEvents(EntityListeners(), this)
    }

    override fun onDisable() {}
}