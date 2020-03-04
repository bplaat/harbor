package ml.bastiaan.containership;

import java.util.ArrayList;

public class ContainerShip {
    private static final int CONTAINER_INIT_COUNT = 100;
    private final ArrayList<Container> containers;

    public ContainerShip() {
        containers = new ArrayList<Container>();
        for (int i = 0; i < CONTAINER_INIT_COUNT; i++) {
            containers.add(new Container());
        }
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public synchronized Container removeContainer() {
        if (containers.size() > 0) {
            return containers.remove(containers.size() - 1);
        } else {
            return null;
        }
    }
}
