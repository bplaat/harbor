package ml.bastiaan.containership;

import java.util.ArrayList;

public class Warehouse {
    private final ArrayList<Container> containers;

    public Warehouse() {
        containers = new ArrayList<Container>();
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public synchronized void addContainer(Container container) {
        containers.add(container);
    }
}
