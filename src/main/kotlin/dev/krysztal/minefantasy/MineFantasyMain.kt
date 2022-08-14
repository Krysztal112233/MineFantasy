package dev.krysztal.minefantasy

import dev.krysztal.minefantasy.listener.EntityListeners
import dev.krysztal.minefantasy.listener.PlayerListeners
import dev.krysztal.minefantasy.utils.LoggerUtil
import dev.krysztal.minefantasy.utils.PluginInstanceUtils
import org.bukkit.plugin.java.JavaPlugin

class MineFantasyMain : JavaPlugin() {
    override fun onEnable() {
        PluginInstanceUtils.plugin = this;
        LoggerUtil.logger = logger;
        server.pluginManager.registerEvents(PlayerListeners(), this)
        server.pluginManager.registerEvents(EntityListeners(), this)
    }

    override fun onDisable() {}
}