package dev.krysztal.minefantasy.foundation


import dev.krysztal.minefantasy.MineFantasyMain
import dev.krysztal.minefantasy.foundation.util.Constants
import dev.krysztal.minefantasy.foundation.util.Constants.Settings.MAX_MANA
import org.bukkit.entity.Player
import org.bukkit.metadata.FixedMetadataValue


fun Player.getMana(): Int {
    val m = this.getMetadata(Constants.MetadataKeys.MANA)
    if (m.isEmpty()) {
        this.setMetadata(Constants.MetadataKeys.MANA, FixedMetadataValue(MineFantasyMain, MAX_MANA))
    }
    // 查询是否为本插件设置的值，是的话就返回剩余魔力值
    for (i in this.getMetadata(Constants.MetadataKeys.MANA)) {
        if (i.owningPlugin == MineFantasyMain)
            return i.asInt()
    }
    return MAX_MANA
}

fun Player.setMana(count: Int) {
    var mana = this.getMana() + count

    if (mana > MAX_MANA) mana = MAX_MANA
    else if (mana < 0) mana = 0

    this.removeMetadata(Constants.MetadataKeys.MANA, MineFantasyMain)
    this.setMetadata(Constants.MetadataKeys.MANA, FixedMetadataValue(MineFantasyMain, mana))

}

fun Player.addMana(count: Int) {
    this.setMana(count)
}

fun Player.decMana(count: Int) {
    this.setMana(-count)
}
