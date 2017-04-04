package edu.matc.TrickOrTreat;

import java.util.LinkedList;

/**
 * Created by student on 4/3/17.
 */
public class EventStatus {
    private LinkedList<Integer> kidsLine;
    private boolean doorBell;
    private boolean candyBowlNotEmpty;
    private boolean givingCandy;
    private Thread rileyThread;
    private Thread spawnThread;
    private int kids;

    public EventStatus() {
        kidsLine = new LinkedList<Integer>();
        kids = 0;
    }

    /**
     * Counts the number of kids in line
     * @return number of kids in line
     */
    synchronized public int countKids() {
        return kidsLine.size();
    }

    /**
     * This add a kid in line
     * @return the kid number added
     */
    synchronized public int addKid() {

        if (kidsLine.size() == 0) {
            doorBell = true;
        }
        kids++;
        kidsLine.addLast(kids);

        return kidsLine.getLast();
    }

    /**
     * This serves the kid in front of the line and removes kid from line.
     * @return the kid number served.
     */
    synchronized public int serveKid() {
        doorBell = false;
        checkNoMoreCandy();
        return kidsLine.poll();
    }

    /**
     * This removes the kid in the end of the line because of impatience.
     * @return impatient kid number.
     */
    synchronized public int kidMoveOn() {
        int moveOnKid = kidsLine.getLast();
        kidsLine.removeLast();
        return moveOnKid;
    }

    /**
     * Check if the door bell is rung
     * @return true if door bell is rung
     */
    synchronized public boolean isDoorBellRung() {
        return doorBell;
    }

    /**
     * Gets candyBowlNotEmpty.
     *
     * @return Value of candyBowlNotEmpty.
     */
    synchronized boolean isCandyBowlNotEmpty() {
        return candyBowlNotEmpty;
    }

    /**
     * Sets new candyBowlNotEmpty.
     *
     * @param candyBowlNotEmpty New value of candyBowlNotEmpty.
     */
    synchronized public void setCandyBowlNotEmpty(boolean candyBowlNotEmpty) {
        this.candyBowlNotEmpty = candyBowlNotEmpty;
    }

    /**
     * Check if bowl is empty
     */
    private void checkNoMoreCandy() {
        if (kidsLine.getFirst() > 50) {
            candyBowlNotEmpty = false;
        }
    }

    /**
     * Sets new spawnThread.
     *
     * @param spawnThread New value of spawnThread.
     */
    public void setSpawnThread(Thread spawnThread) {
        this.spawnThread = spawnThread;
    }

    /**
     * Gets rileyThread.
     *
     * @return Value of rileyThread.
     */
    public Thread getRileyThread() {
        return rileyThread;
    }

    /**
     * Gets spawnThread.
     *
     * @return Value of spawnThread.
     */
    public Thread getSpawnThread() {
        return spawnThread;
    }

    /**
     * Sets new rileyThread.
     *
     * @param rileyThread New value of rileyThread.
     */
    public void setRileyThread(Thread rileyThread) {
        this.rileyThread = rileyThread;
    }

    /**
     * Gets givingCandy.
     *
     * @return Value of givingCandy.
     */
    public boolean isGivingCandy() {
        return givingCandy;
    }

    /**
     * Sets new givingCandy.
     *
     * @param givingCandy New value of givingCandy.
     */
    public void setGivingCandy(boolean givingCandy) {
        this.givingCandy = givingCandy;
    }
}
