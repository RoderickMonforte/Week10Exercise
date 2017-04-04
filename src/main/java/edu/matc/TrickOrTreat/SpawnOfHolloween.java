package edu.matc.TrickOrTreat;

import org.apache.log4j.Logger;

/**
 * Created by student on 4/3/17.
 */
public class SpawnOfHolloween implements Runnable {
    EventStatus status;
    private final Logger log = Logger.getLogger(this.getClass());

    public SpawnOfHolloween(EventStatus status) {
        this.status = status;
    }

    /**
     * This spawns kids in holloween costumes.
     */
    public void run() {
        while(status.countKids() < 11 && status.isCandyBowlNotEmpty()) {

            for (int i=1 ; i <= (int) ((Math.random() * 2) + 1); i++) {
                addKids();
            }

            if (!status.isGivingCandy()) {
                status.getRileyThread().interrupt();
            }
            delay();
        }
    }

    /**
     * This adds kids
     */
    private void addKids() {
        int kidNumber = 0;

        kidNumber = status.addKid();
        if (status.countKids() == 1) {
            log.info("Kid #" + kidNumber + " rings doorbell. ding! " +
                    "dong! Trick or treat!");
        } else if (status.countKids() == 11) {
            log.info("Kid #" + status.kidMoveOn() + " moves on because line " +
                    "is too long.");
        } else {
            log.info("Kid #" + kidNumber + " gets in line. There are " +
                    status.countKids() + " kids in line.");
        }

    }

    /**
     * This is the delay.
     */
    private void delay() {
        try {
            Thread.sleep((long) (Math.random() * 9000));
        } catch (InterruptedException e) {
            log.info("Kid is impatient.");
        }

    }
}
