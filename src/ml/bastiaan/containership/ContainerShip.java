package ml.bastiaan.containership;

import java.util.ArrayList;

public class ContainerShip {
    private static final int CONTAINER_COUNT = 100;
    private final ArrayList<Container> containers;

    public ContainerShip() {
        containers = new ArrayList<Container>();
        for (int i = 0; i < CONTAINER_COUNT; i++) {
            containers.add(new Container());
        }
    }
}
