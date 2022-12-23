package dev.krysztal.minefantasy.crystal

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WhiteMageCrystalTest {
    @Test
    @DisplayName("Use Blood Lily")
    fun testUseBloodLily() {
        var crystal = WhiteMageCrystal()
        crystal.decrease("Blood Lily", 1)
        Assertions.assertEquals(0, crystal.getCurrentInSlot("Blood Lily"))
        crystal = WhiteMageCrystal()
        crystal.increase("Blood Lily", 3)
        Assertions.assertEquals(3, crystal.getCurrentInSlot("Blood Lily"))
        crystal = WhiteMageCrystal()
        crystal.increase("Blood Lily", 4)
        Assertions.assertEquals(3, crystal.getCurrentInSlot("Blood Lily"))
    }

    @Test
    @DisplayName("Use Lily")
    fun testUseLily() {
        var crystal = WhiteMageCrystal()
        crystal.decrease("Lily", 1)
        Assertions.assertEquals(0, crystal.getCurrentInSlot("Lily"))
        crystal = WhiteMageCrystal()
        crystal.increase("Lily", 3)
        Assertions.assertEquals(3, crystal.getCurrentInSlot("Lily"))
        crystal = WhiteMageCrystal()
        crystal.increase("Lily", 4)
        Assertions.assertEquals(3, crystal.getCurrentInSlot("Lily"))
    }
}