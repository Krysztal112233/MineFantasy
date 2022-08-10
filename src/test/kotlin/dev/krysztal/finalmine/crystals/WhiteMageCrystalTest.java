package dev.krysztal.finalmine.crystals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhiteMageCrystalTest {

    @Test
    @DisplayName("Use Blood Lily")
    public void testUseBloodLily() {
        var crystal = new WhiteMageCrystal();
        crystal.decrease(WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY, 1);
        Assertions.assertEquals(0, crystal.getCurrentInSlot(WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY));

        crystal = new WhiteMageCrystal();
        crystal.increase(WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY, 3);
        Assertions.assertEquals(3, crystal.getCurrentInSlot(WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY));

        crystal = new WhiteMageCrystal();
        crystal.increase(WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY, 4);
        Assertions.assertEquals(3, crystal.getCurrentInSlot(WhiteMageCrystal.WhiteMageSlots.BLOOD_LILY));
    }

    @Test
    @DisplayName("Use Lily")
    public void testUseLily() {
        var crystal = new WhiteMageCrystal();
        crystal.decrease(WhiteMageCrystal.WhiteMageSlots.LILY, 1);
        Assertions.assertEquals(0, crystal.getCurrentInSlot(WhiteMageCrystal.WhiteMageSlots.LILY));

        crystal = new WhiteMageCrystal();
        crystal.increase(WhiteMageCrystal.WhiteMageSlots.LILY, 3);
        Assertions.assertEquals(3, crystal.getCurrentInSlot(WhiteMageCrystal.WhiteMageSlots.LILY));

        crystal = new WhiteMageCrystal();
        crystal.increase(WhiteMageCrystal.WhiteMageSlots.LILY, 4);
        Assertions.assertEquals(3, crystal.getCurrentInSlot(WhiteMageCrystal.WhiteMageSlots.LILY));
    }

}