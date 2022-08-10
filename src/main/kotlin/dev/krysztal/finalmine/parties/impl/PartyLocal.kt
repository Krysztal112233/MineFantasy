package dev.krysztal.finalmine.parties.impl

import dev.krysztal.finalmine.interfaces.IParty

import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import java.util.function.Consumer

class PartyLocal : IParty {

    private val parties: ConcurrentMap<String, MutableSet<UUID>?> = ConcurrentHashMap()
    override fun joinParty(party: String, uuid: UUID) {
        this.removeMember(uuid)
        val s = Optional.ofNullable<MutableSet<UUID>>(this.parties[party]).orElse(HashSet())
        s.add(uuid)
        parties[party] = s
    }

    override fun removeMember(party: String, member: UUID) {
        val i = Optional.ofNullable(parties[party]).orElse(HashSet())
        i!!.remove(member)
        parties[party] = i
    }

    override fun removeMember(member: UUID) {
        parties.keys.forEach(Consumer { v: String -> this.removeMember(v, member) })
    }

    override fun removeParty(party: String) {
        if (parties[party] != null) parties.remove(party)
    }

    override fun getCurrentParty(uuid: UUID): Optional<String> {
        for ((key, value) in this.parties.entries) {
            for (item in value!!) {
                if (item === uuid) return Optional.ofNullable(key)
            }
        }
        return Optional.empty()
    }
}