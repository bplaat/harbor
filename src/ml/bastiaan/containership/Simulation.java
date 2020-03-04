// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

import java.util.ArrayList;

public class Simulation {
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
        for (Crane crane : cranes) {
            crane.start();
        }

        for (Truck truck : trucks) {
            truck.start();
        }
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
