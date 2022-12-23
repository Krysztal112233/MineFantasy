package dev.krysztal.minefantasy.foundation.`interface`

import java.util.*

interface Party {
    fun joinParty(party: String, uuid: UUID)
    fun removeMember(party: String, member: UUID)
    fun removeMember(member: UUID)
    fun removeParty(party: String)
    fun getCurrentParty(uuid: UUID): Optional<String>
}