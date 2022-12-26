package dev.krysztal.minefantasy.command

import dev.krysztal.minefantasy.foundation.decMana
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ManaCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args?.size!! < 3 || sender !is Player) return false

        val player = args[1]
        val mana = args[2]

        sender.server.getPlayer(player)?.decMana(-mana.toInt())

        return true
    }
}