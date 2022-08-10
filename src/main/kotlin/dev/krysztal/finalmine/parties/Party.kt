package dev.krysztal.finalmine.parties

import dev.krysztal.finalmine.interfaces.IParty
import dev.krysztal.finalmine.parties.impl.PartyLocal
import java.util.*

object Party {
    private var partyInstance: IParty? = null
    val instance: IParty?
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