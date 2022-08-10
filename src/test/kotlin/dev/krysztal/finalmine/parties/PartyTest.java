package dev.krysztal.finalmine.parties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class PartyTest {
    @Test
    @DisplayName("Player join party")
    void joinParty() {
        var u = UUID.randomUUID();
        Party.joinParty("Test", u);
        Assertions.assertEquals(Party.getCurrentParty(u).get(), "Test");

        Party.joinParty("Null", u);
        Assertions.assertEquals(Party.getCurrentParty(u).get(), "Null");
    }

    @Test
    @DisplayName("Remove player from party")
    void removeMember() {
        var u = UUID.randomUUID();
        Party.joinParty("Test", u);
        Assertions.assertEquals(Party.getCurrentParty(u).get(), "Test");
        Party.removeMember(u);
        Assertions.assertTrue(Party.getCurrentParty(u).isEmpty());
    }

    @Test
    @DisplayName("Delete party")
    void deleteParty() {
        var u = UUID.randomUUID();
        Party.joinParty("Test", u);
        Assertions.assertEquals(Party.getCurrentParty(u).get(), "Test");
        Party.removeParty("Test");
        Assertions.assertTrue(Party.getCurrentParty(u).isEmpty());
    }
}