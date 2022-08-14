package dev.krysztal.minefantasy.parties

import dev.krysztal.minefantasy.interfaces.IParty
import dev.krysztal.minefantasy.parties.impl.PartyLocal
import java.util.*

object Party {
    private var partyInstance: IParty? = null
    private val instance: IParty?
        get() {
            if (partyInstance == null) partyInstance = PartyLocal()
            return partyInstance
        }


    fun joinParty(party: String, uuid: UUID) {
        instance!!.joinParty(party, uuid)
    }

    fun removeMember(party: String, member: UUID) {
        instance!!.removeMember(party, member)
    }


    fun removeMember(member: UUID) {
        instance!!.removeMember(member)
    }


    fun removeParty(party: String) {
        instance!!.removeParty(party)
    }


    fun getCurrentParty(uuid: UUID): Optional<String> {
        return instance!!.getCurrentParty(uuid)
    }
}