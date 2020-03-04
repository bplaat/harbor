// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

abstract public class Mover implements Runnable {
    protected final String name;
    protected final ContainerHolder from;
    protected final ContainerHolder to;
    protected final Thread thread;
    protected volatile boolean waiting;
    protected volatile Container container;

    public Mover(String name, ContainerHolder from, ContainerHolder to) {
        this.name = name;
        this.from = from;
        this.to = to;
        thread = new Thread(this, name);
    }

    public void run() {
        while (true) {
            container = from.removeContainer();
            if (container != null) {
                waiting = false;
                System.out.println(name + " removed " + container.getName() + " from " + from.getName());

                try {
                    Thread.sleep(Utils.rand(1000, 6000));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                waiting = true;
                while (!to.addContainer(container));
                System.out.println(name + " added " + container.getName() + " to " + to.getName());
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

    public Container getContainer() {
        return container;
    }
}
