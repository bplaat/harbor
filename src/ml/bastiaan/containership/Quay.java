package ml.bastiaan.containership;

import java.util.ArrayList;

public class Quay {
    private final ContainerShip containership;

    private static final int CRANE_INIT_COUNT = 2;
    private final ArrayList<Crane> cranes;

    private static final int CONTAINER_MAX_COUNT = 5;
    private final ArrayList<Container> containers;

    private static final int TRUCK_INIT_COUNT = 3;
    private final ArrayList<Truck> trucks;

    private final Warehouse warehouse;

    public Quay() {
        containership = new ContainerShip();

        cranes = new ArrayList<Crane>();
        for (int i = 1; i <= CRANE_INIT_COUNT; i++) {
            cranes.add(new Crane("Crane " + i, containership, this));
        }

        containers = new ArrayList<Container>();

        warehouse = new Warehouse();

        trucks = new ArrayList<Truck>();
        for (int i = 1; i <= TRUCK_INIT_COUNT; i++) {
            trucks.add(new Truck("Truck " + i, this, warehouse));
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

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public synchronized boolean addContainer(Container container) {
        if (containers.size() < CONTAINER_MAX_COUNT) {
            containers.add(container);
            return true;
        } else {
            return false;
        }
    }

    public synchronized Container removeContainer() {
        if (containers.size() > 0) {
            return containers.remove(containers.size() - 1);
        } else {
            return null;
        }
    }
}
