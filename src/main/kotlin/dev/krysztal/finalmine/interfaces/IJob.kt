package dev.krysztal.finalmine.interfaces

import org.bukkit.entity.Player

interface IJob {
    fun setJob(player: Player)
    fun getJob(player: Player)
}