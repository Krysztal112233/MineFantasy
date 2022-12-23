package dev.krysztal.minefantasy.foundation.util

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.World
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

object ParticleUtils {
    fun spawn(particle: Particle, player: Player, loc: Location?, count: Int) {
        player.spawnParticle(particle, loc!!, count, 0.3, 1.0, 0.3, (1000 * 5).toDouble())
    }


    private fun spawn(particle: Particle, world: World, loc: Location?, count: Int) {
        world.spawnParticle(particle, loc!!, count, 0.3, 1.0, 0.3, (1000 * 5).toDouble())
    }

    fun spawnCureParticle(entity: LivingEntity?) {
        spawn(
            Particle.COMPOSTER,
            entity!!.world,
            entity.location.clone().set(
                entity.location.x,
                entity.location.y + 1,
                entity.location.z
            ),
            50
        )
    }

    fun spawnHurtParticle(entity: LivingEntity?) {
        spawn(
            Particle.REDSTONE,
            entity!!.world,
            entity.location.clone().set(
                entity.location.x,
                entity.location.y + 1,
                entity.location.z
            ),
            50
        )
    }
}