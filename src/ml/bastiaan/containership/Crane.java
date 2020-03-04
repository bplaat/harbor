package ml.bastiaan.containership;

public class Crane implements Runnable {
    private final String name;
    private final ContainerShip containership;
    private final Quay quay;
    private final Thread thread;
    private volatile boolean running;
    private volatile boolean waiting;
    private volatile Container container;

    public Crane(String name, ContainerShip containership, Quay quay) {
        this.name = name;
        this.containership = containership;
        this.quay = quay;
        thread = new Thread(this, name);
    }

    public void run() {
        while (running) {
            container = containership.removeContainer();
            if (container != null) {
                waiting = false;
                System.out.println(name + " removed " + container.getName() + " from the containership");

                try {
                    Thread.sleep(Utils.rand(500, 2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                waiting = true;
                while (!quay.addContainer(container));

                System.out.println(name + " added " + container.getName() + " to the quay");
                container = null;
            }

            else {
                running = false;
            }
        }
    }

    public void start() {
        running = true;
        waiting = true;
        thread.start();
    }

    public String getName() {
        return name;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public synchronized Container getContainer() {
        return container;
    }
}
