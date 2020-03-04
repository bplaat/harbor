package ml.bastiaan.containership;

public class Truck implements Runnable {
    private final String name;
    private final Quay quay;
    private final Warehouse warehouse;
    private final Thread thread;
    private volatile boolean running;
    private volatile boolean waiting;
    private volatile Container container;

    public Truck(String name, Quay quay, Warehouse warehouse) {
        this.name = name;
        this.quay = quay;
        this.warehouse = warehouse;
        thread = new Thread(this, name);
    }

    public void run() {
        while (running) {
            container = quay.removeContainer();
            if (container != null) {
                waiting = false;
                System.out.println(name + " removed " + container.getName() + " from the quay");
                if (container.getType() == Container.Type.HEATED) {
                    System.out.println(name + " connect " + container.getName() + " with a heat element");
                }
                if (container.getType() == Container.Type.COOLED) {
                    System.out.println(name + " connect " + container.getName() + " with a cooling element");
                }

                try {
                    Thread.sleep(Utils.rand(1000, 6000));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                warehouse.addContainer(container);
                System.out.println(name + " added " + container.getName() + " to the warehouse");
                waiting = true;
                container = null;
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
