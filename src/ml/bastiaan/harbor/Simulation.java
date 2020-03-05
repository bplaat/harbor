// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.util.ArrayList;

public class Simulation {
    private final ContainerShip containerShip;
    private final ArrayList<ContainerCrane> containerCranes;

    private final OilShip oilShip;
    private final ArrayList<OilPump> oilPumps;

    private final Quay quay;
    private final ArrayList<Truck> trucks;
    private final Warehouse warehouse;
    private boolean running;
    private boolean playing;

    public Simulation() {
        containerShip = new ContainerShip("Container Ship");

        oilShip = new OilShip("Oil Ship");

        quay = new Quay("Quay");

        containerCranes = new ArrayList<ContainerCrane>();
        for (int i = 1; i <= 3; i++) {
            containerCranes.add(new ContainerCrane("Container Crane " + i, containerShip, quay));
        }

        oilPumps = new ArrayList<OilPump>();
        for (int i = 1; i <= 2; i++) {
            oilPumps.add(new OilPump("Oil Pump " + i, oilShip, quay));
        }

        warehouse = new Warehouse("Warehouse");

        trucks = new ArrayList<Truck>();
        for (int i = 1; i <= 3; i++) {
            trucks.add(new Truck("Container Truck " + i, quay, warehouse, Truck.Type.CONTAINER));
        }
        for (int i = 1; i <= 3; i++) {
            trucks.add(new Truck("Oil Truck " + i, quay, warehouse, Truck.Type.OIL_BARREL));
        }
    }

    public void start() {
        System.out.println("Simulation started");

        running = true;
        playing = true;

        containerShip.start();

        for (ContainerCrane containerCrane : containerCranes) {
            containerCrane.start();
        }

        oilShip.start();

        for (OilPump oilPump : oilPumps) {
            oilPump.start();
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

        containerShip.stop();

        for (ContainerCrane containerCrane : containerCranes) {
            containerCrane.stop();
        }

        oilShip.stop();

        for (OilPump oilPump : oilPumps) {
            oilPump.stop();
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

        containerShip.play();

        for (ContainerCrane containerCrane : containerCranes) {
            containerCrane.play();
        }

        oilShip.play();

        for (OilPump oilPump : oilPumps) {
            oilPump.play();
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

        containerShip.pause();

        for (ContainerCrane containerCrane : containerCranes) {
            containerCrane.pause();
        }

        oilShip.pause();

        for (OilPump oilPump : oilPumps) {
            oilPump.pause();
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
        return containerShip;
    }

    public ArrayList<ContainerCrane> getContainerCranes() {
        return containerCranes;
    }

    public OilShip getOilShip() {
        return oilShip;
    }

    public ArrayList<OilPump> getOilPumps() {
        return oilPumps;
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
