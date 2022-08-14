package dev.krysztal.minefantasy.mana


import dev.krysztal.minefantasy.utils.Constants
import dev.krysztal.minefantasy.utils.Constants.Settings.MAX_MANA
import dev.krysztal.minefantasy.utils.PluginInstanceUtils
import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue

object Mana {


    fun getMana(player: Player): Int {
        val m = player.getMetadata(Constants.MetadataKeys.MANA)
        if (m.isEmpty()) {
            player.setMetadata(Constants.MetadataKeys.MANA, FixedMetadataValue(PluginInstanceUtils.plugin, MAX_MANA))
        }
        // 查询是否为本插件设置的值，是的话就返回剩余魔力值
        for (i in player.getMetadata(Constants.MetadataKeys.MANA)) {
            if (i.owningPlugin == PluginInstanceUtils.plugin)
                return i.asInt()
        }
        return MAX_MANA
    }

    fun setMana(player: Player, count: Int) {
        var mana = this.getMana(player) + count

        if (mana > MAX_MANA) mana = MAX_MANA
        else if (mana < 0) mana = 0

        player.removeMetadata(Constants.MetadataKeys.MANA, PluginInstanceUtils.plugin)
        player.setMetadata(Constants.MetadataKeys.MANA, FixedMetadataValue(PluginInstanceUtils.plugin, mana))

    }

    fun addMana(player: Player, count: Int) {
        this.setMana(player, count)
    }

    fun decMana(player: Player, count: Int) {
        this.setMana(player, -count)
    }
}