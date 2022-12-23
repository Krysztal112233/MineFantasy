package dev.krysztal.minefantasy.foundation

import dev.krysztal.minefantasy.foundation.util.Constants.MetadataKeys
import dev.krysztal.raid.RAID
import org.bukkit.entity.Player
import org.bukkit.entity.SpawnCategory


var partyFilter: EntityFilter = label@{ entity, player ->
    if (entity !is Player) return@label false
    if (entity.getUniqueId() === player.uniqueId) return@label true
    val playerParty = RAID.party.getParty(player.uniqueId)
    val targetParty = RAID.party.getParty(entity.getUniqueId())
    targetParty == playerParty
}

var forEnemy: EntityFilter = label@{ entity, _ ->
    if (entity == null) return@label false
    val metadata = entity.getMetadata(MetadataKeys.IS_ENEMY)
    if (metadata.size != 0) return@label metadata[0].asBoolean()
    false
}

var monsterFilter: EntityFilter = label@{ entity, _ ->
    (entity?.spawnCategory ?: SpawnCategory.MISC) == SpawnCategory.MONSTER
}

var playerFilter: EntityFilter = label@{ entity, _ ->
    entity is Player
}
