package dev.krysztal.minefantasy.mana


import dev.krysztal.minefantasy.MineFantasyMain
import dev.krysztal.minefantasy.foundation.utils.Constants
import dev.krysztal.minefantasy.foundation.utils.Constants.Settings.MAX_MANA
import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue

object Mana {


    fun getMana(player: Player): Int {
        val m = player.getMetadata(Constants.MetadataKeys.MANA)
        if (m.isEmpty()) {
            player.setMetadata(Constants.MetadataKeys.MANA, FixedMetadataValue(MineFantasyMain, MAX_MANA))
        }
        // 查询是否为本插件设置的值，是的话就返回剩余魔力值
        for (i in player.getMetadata(Constants.MetadataKeys.MANA)) {
            if (i.owningPlugin == MineFantasyMain)
                return i.asInt()
        }
        return MAX_MANA
    }

    fun setMana(player: Player, count: Int) {
        var mana = this.getMana(player) + count

        if (mana > MAX_MANA) mana = MAX_MANA
        else if (mana < 0) mana = 0

        player.removeMetadata(Constants.MetadataKeys.MANA, MineFantasyMain)
        player.setMetadata(Constants.MetadataKeys.MANA, FixedMetadataValue(MineFantasyMain, mana))

    }

    fun addMana(player: Player, count: Int) {
        this.setMana(player, count)
    }

    fun decMana(player: Player, count: Int) {
        this.setMana(player, -count)
    }
}