// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

import java.util.ArrayList;

// The main simulation container
public class Simulation {
    // Final fields for all the classes / items of the simulation
    private final ContainerShip containerShip;
    private final ArrayList<ContainerCrane> containerCranes;

    private final OilShip oilShip;
    private final ArrayList<OilPump> oilPumps;

    private final Quay quay;
    private final ArrayList<Truck> trucks;
    private final Warehouse warehouse;

    // Active state fields
    private boolean running;
    private boolean playing;

    // Create all the simulation classes / items
    public Simulation() {
        containerShip = new ContainerShip("Container Ship");

        oilShip = new OilShip("Oil Ship");

        quay = new Quay("Quay");

        containerCranes = new ArrayList<ContainerCrane>();
        for (int i = 1; i <= 2; i++) {
            containerCranes.add(new ContainerCrane("Container Crane " + i, containerShip, quay));
        }

        oilPumps = new ArrayList<OilPump>();
        for (int i = 1; i <= 2; i++) {
            oilPumps.add(new OilPump("Oil Pump " + i, oilShip, quay));
        }

        warehouse = new Warehouse("Warehouse");

        trucks = new ArrayList<Truck>();
        for (int i = 1; i <= 3; i++) {
            trucks.add(new ContainerTruck("Container Truck " + i, quay, warehouse));
        }
        for (int i = 1; i <= 3; i++) {
            trucks.add(new OilTruck("Oil Truck " + i, quay, warehouse));
        }
    }

    // Start the simulation and all the simulation classes
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

    // Stop the simulation and all the simulation classes
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

    // Play the simulation and all the simulation classes
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

    // Pause the simulation and all the simulation classes
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

    // Tell if the simulation is running
    public boolean isRunning() {
        return running;
    }

    // Tell is the simulation is playing
    public boolean isPlaying() {
        return playing;
    }

    // Get the container ship
    public ContainerShip getContainerShip() {
        return containerShip;
    }

    // Get the container cranes
    public ArrayList<ContainerCrane> getContainerCranes() {
        return containerCranes;
    }

    // Get the oil ship
    public OilShip getOilShip() {
        return oilShip;
    }

    // Get the oil pumps
    public ArrayList<OilPump> getOilPumps() {
        return oilPumps;
    }

    // Get the quay
    public Quay getQuay() {
        return quay;
    }

    // Get the trucks
    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    // Get the warehouse
    public Warehouse getWarehouse() {
        return warehouse;
    }
}
