// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

public class Truck implements Runnable {
    private final String name;
    private final Quay quay;
    private final Warehouse warehouse;
    private final Thread thread;
    private volatile boolean waiting;
    private volatile Container container;

    public Truck(String name, Quay quay, Warehouse warehouse) {
        this.name = name;
        this.quay = quay;
        this.warehouse = warehouse;
        thread = new Thread(this, name);
    }

    public void run() {
        while (true) {
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

                waiting = true;
                while (!warehouse.addContainer(container));
                System.out.println(name + " added " + container.getName() + " to the warehouse");
            }
        }
    }

    public void start() {
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
