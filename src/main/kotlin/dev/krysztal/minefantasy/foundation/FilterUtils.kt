package dev.krysztal.minefantasy.foundation

import dev.krysztal.minefantasy.foundation.utils.Constants.MetadataKeys
import dev.krysztal.minefantasy.parties.Party
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.SpawnCategory


var partyFilter: (LivingEntity?, Player) -> Boolean = label@{ entity, player ->
    if (entity !is Player) return@label false
    if (entity.getUniqueId() === player.uniqueId) return@label true
    val playerParty = Party.getCurrentParty(player.uniqueId)
    val targetParty = Party.getCurrentParty(entity.getUniqueId())
    targetParty == playerParty
}

var forEnemy: (LivingEntity?, Player) -> Boolean = label@{ entity, _ ->
    if (entity == null) return@label false
    val metadata = entity.getMetadata(MetadataKeys.IS_ENEMY)
    if (metadata.size != 0) return@label metadata[0].asBoolean()
    false
}

var monsterFilter: (LivingEntity?, Player) -> Boolean = label@{ entity, _ ->
    (entity?.spawnCategory ?: SpawnCategory.MISC) == SpawnCategory.MONSTER
}

var playerFilter: (LivingEntity?, Player) -> Boolean = label@{ entity, _ ->
    entity is Player
}
