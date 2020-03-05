// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.util.ArrayList;

public class Simulation {
    private boolean running;
    private boolean playing;

    private final ContainerShip containership;

    public static final int CRANE_INIT_COUNT = 2;
    private final ArrayList<Crane> cranes;

    private final Quay quay;

    public static final int TRUCK_INIT_COUNT = 3;
    private final ArrayList<Truck> trucks;

    private final Warehouse warehouse;

    public Simulation() {
        containership = new ContainerShip("Container Ship");

        quay = new Quay("Quay");

        cranes = new ArrayList<Crane>();
        for (int i = 1; i <= CRANE_INIT_COUNT; i++) {
            cranes.add(new Crane("Crane " + i, containership, quay));
        }

        warehouse = new Warehouse("Warehouse");

        trucks = new ArrayList<Truck>();
        for (int i = 1; i <= TRUCK_INIT_COUNT; i++) {
            trucks.add(new Truck("Truck " + i, quay, warehouse));
        }
    }

    public void start() {
        System.out.println("Simulation started");

        running = true;
        playing = true;

        containership.start();

        for (Crane crane : cranes) {
            crane.start();
        }

        quay.start();

        for (Truck truck : trucks) {
            truck.start();
        }

        warehouse.start();
    }

    public void stop() {
        System.out.println("Simulation stoped");

        running = false;
        playing = false;

        containership.stop();

        for (Crane crane : cranes) {
            crane.stop();
        }

        quay.stop();

        for (Truck truck : trucks) {
            truck.stop();
        }

        warehouse.stop();
    }

    public void play() {
        System.out.println("Simulation resumed");

        playing = true;

        containership.play();

        for (Crane crane : cranes) {
            crane.play();
        }

        quay.play();

        for (Truck truck : trucks) {
            truck.play();
        }

        warehouse.play();
    }

    public void pause() {
        System.out.println("Simulation paused");

        playing = false;

        containership.pause();

        for (Crane crane : cranes) {
            crane.pause();
        }

        quay.pause();

        for (Truck truck : trucks) {
            truck.pause();
        }

        warehouse.pause();
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isPlaying() {
        return playing;
    }

    public ContainerShip getContainerShip() {
        return containership;
    }

    public ArrayList<Crane> getCranes() {
        return cranes;
    }

    public Quay getQuay() {
        return quay;
    }

    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
