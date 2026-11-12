
package com.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.model.Victim;
import com.model.VictimStatus;

public class VictimTest {

    @Test
    public void testVictimFirstName() {
        Victim victim = new Victim("Bartholomew", VictimStatus.values()[0], 25);

        assertEquals("Bartholomew", victim.getFirstName());
    }

    @Test
    public void testVictimAge() {
        Victim victim = new Victim("Bartholomew", VictimStatus.values()[0], 25);

        assertEquals(25, victim.getAge());
    }

    @Test
    public void testVictimStatus() {
        VictimStatus status = VictimStatus.values()[0];
        Victim victim = new Victim("Bartholomew", status, 25);

        assertEquals(status, victim.getVictimStatus());
    }

    @Test
    public void testUpdateVictimStatus() {
        VictimStatus firstStatus = VictimStatus.values()[0];
        VictimStatus newStatus = VictimStatus.values()[1];

        Victim victim = new Victim("Bartholomew", firstStatus, 25);
        victim.setVictimStatus(newStatus);

        assertEquals(newStatus, victim.getVictimStatus());
    }
}
