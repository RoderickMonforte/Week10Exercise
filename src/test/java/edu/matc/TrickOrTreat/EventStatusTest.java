package edu.matc.TrickOrTreat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by student on 4/3/17.
 */
public class EventStatusTest {
    EventStatus status;
    @Before
    public void setUp() throws Exception {
        status = new EventStatus();

    }

    @Test
    public void countKids() throws Exception {
        assertEquals("Should be zero", 0, status.countKids());
    }

    @Test
    public void addKid() throws Exception {
        status.addKid();
        assertEquals("Should be 1",1,status.countKids());
        status.serveKid();
    }

    @Test
    public void serveKid() throws Exception {
        int newKid = status.addKid();
        assertEquals("should be equal", newKid, status.serveKid());
    }

    @Test
    public void kidMoveOn() throws Exception {
        int newKid = status.addKid();
        assertEquals("should be equal", newKid, status.kidMoveOn());

    }

}