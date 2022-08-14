package dev.krysztal.minefantasy.utils

import dev.krysztal.minefantasy.interfaces.IApplyFilter
import dev.krysztal.minefantasy.parties.Party
import dev.krysztal.minefantasy.utils.Constants.MetadataKeys
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.SpawnCategory

object FilterUtils {
    var forParty = IApplyFilter { entity: LivingEntity?, player: Player? ->
        if (entity !is Player) return@IApplyFilter false
        if (entity.getUniqueId() === player!!.uniqueId) return@IApplyFilter true
        val playerParty = Party.getCurrentParty(player!!.uniqueId)
        if (player.isEmpty) return@IApplyFilter false
        val targetParty = Party.getCurrentParty(entity.getUniqueId())
        targetParty == playerParty
    }

    var forEnemy = IApplyFilter { entity: LivingEntity?, player: Player? ->
        if (entity == null) return@IApplyFilter false
        val metadata = entity.getMetadata(MetadataKeys.IS_ENEMY)
        if (metadata.size != 0) return@IApplyFilter metadata[0].asBoolean()
        false
    }

    var forMonster = IApplyFilter { entity, _ ->
        (entity?.spawnCategory ?: SpawnCategory.MISC) == SpawnCategory.MONSTER
    }

    var forPlayer = IApplyFilter { entity, _ ->
        entity is Player
    }
}