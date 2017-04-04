package edu.matc.TrickOrTreat;
import org.apache.log4j.Logger;

/**
 * Created by student on 4/3/17.
 */
public class Riley implements Runnable {
    EventStatus status;
    private final Logger log = Logger.getLogger(this.getClass());

    public Riley(EventStatus status) {
        this.status = status;
        log.info("Riley is watching the \"It’s the Great Pumpkin, Charlie " +
                "Brown\"");
    }

    /**
     * Riley watches TV until doorbell is heard. Gives candy to all kids in
     * line and goes back to watching. Says sorry when candy runs out.
     */
    public void run() {
        while (status.isCandyBowlNotEmpty()) {
            if (status.isDoorBellRung()) {
                delay(3000);
                log.info("Riley answers the door and gives candy to kid #" +
                        status.serveKid());
                status.setGivingCandy(true);
            } else if (status.countKids() > 0) {
                delay(3000);
                log.info("Riley gives candy to kid #" +status.serveKid());
                status.setGivingCandy(true);
            } else {
                log.info("Riley continues to watch the \"It’s the Great " +
                        "Pumpkin, Charlie Brown\"");
                status.setGivingCandy(false);
                delay(10000);
            }
        }
        if (status.isCandyBowlNotEmpty()) {
            log.info("Sorry kids! No more candy =) ... trick then =(");
        }
    }

    /**
     * This is the delay
     * @param duration
     */
    private void delay(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            if (duration > 3000) {
                log.info("Riley stops watching.");
            }
        }
    }
}
