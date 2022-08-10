package dev.krysztal.finalmine

import dev.krysztal.finalmine.listener.EntityListeners
import dev.krysztal.finalmine.listener.PlayerListeners
import dev.krysztal.finalmine.utils.LoggerUtil
import dev.krysztal.finalmine.utils.PluginInstanceUtils
import org.bukkit.plugin.java.JavaPlugin

class FinalMineMain : JavaPlugin() {
    override fun onEnable() {
        PluginInstanceUtils.plugin = this;
        LoggerUtil.logger = logger;
        server.pluginManager.registerEvents(PlayerListeners(), this)
        server.pluginManager.registerEvents(EntityListeners(), this)
    }

    override fun onDisable() {}
}