package dev.krysztal.minefantasy.parties

import dev.krysztal.minefantasy.parties.Party.getCurrentParty
import dev.krysztal.minefantasy.parties.Party.joinParty
import dev.krysztal.minefantasy.parties.Party.removeMember
import dev.krysztal.minefantasy.parties.Party.removeParty
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

internal class PartyTest {
    @Test
    @DisplayName("Player join party")
    fun joinParty() {
        val u = UUID.randomUUID()
        joinParty("Test", u)
        Assertions.assertEquals(getCurrentParty(u).get(), "Test")
        joinParty("Null", u)
        Assertions.assertEquals(getCurrentParty(u).get(), "Null")
    }

    @Test
    @DisplayName("Remove player from party")
    fun removeMember() {
        val u = UUID.randomUUID()
        joinParty("Test", u)
        Assertions.assertEquals(getCurrentParty(u).get(), "Test")
        removeMember(u)
        Assertions.assertTrue(getCurrentParty(u).isEmpty)
    }

    @Test
    @DisplayName("Delete party")
    fun deleteParty() {
        val u = UUID.randomUUID()
        joinParty("Test", u)
        Assertions.assertEquals(getCurrentParty(u).get(), "Test")
        removeParty("Test")
        Assertions.assertTrue(getCurrentParty(u).isEmpty)
    }
}