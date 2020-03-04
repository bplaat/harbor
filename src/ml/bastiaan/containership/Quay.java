package ml.bastiaan.containership;

import java.util.ArrayList;

public class Quay {
    private static final int CRANE_COUNT = 2;
    private final ArrayList<Crane> cranes;

    private static final int TRUCK_COUNT = 2;
    private final ArrayList<Truck> trucks;

    private static final int MAX_CONTAINER_COUNT = 5;
    private final ArrayList<Container> containers;

    public Quay() {
        cranes = new ArrayList<Crane>();
        for (int i = 0; i < CRANE_COUNT; i++) {
            Crane crane = new Crane("Crane " + i);
            cranes.add(crane);
            crane.start();
        }

        trucks = new ArrayList<Truck>();
        for (int i = 0; i < TRUCK_COUNT; i++) {
            Truck truck = new Truck("Truck " + i);
            trucks.add(truck);
            truck.start();
        }

        containers = new ArrayList<Container>();
    }
}
