package edu.matc.TrickOrTreat;

/**
 * Creates two threads to mimic holloween candy giving fact of life.
 *
 */
public class TrickOrTreat
{
    public static void main( String[] args )
    {
        EventStatus status = new EventStatus();
        status.setCandyBowlNotEmpty(true);

        SpawnOfHolloween spawn = new SpawnOfHolloween(status);
        Riley riley = new Riley(status);

        Thread runningRiley = new Thread(riley);
        Thread runningSpawn = new Thread(spawn);

        status.setRileyThread(runningRiley);
        status.setSpawnThread(runningSpawn);

        runningRiley.start();
        runningSpawn.start();

    }
}
