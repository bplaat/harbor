// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

abstract public class Mover implements Runnable {
    protected final String name;
    protected final ContainerHolder from;
    protected final ContainerHolder to;
    protected final int maxWaitingTime;
    protected final Thread thread;
    protected volatile boolean waiting;
    protected volatile Container container;

    public Mover(String name, ContainerHolder from, ContainerHolder to, int maxWaitingTime) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.maxWaitingTime = maxWaitingTime;
        thread = new Thread(this, name);
    }

    public void run() {
        while (true) {
            container = from.removeContainer();
            if (container != null) {
                waiting = false;
                System.out.println(name + " removed " + container.getName() + " from " + from.getName());
                handleContainer(container);

                try {
                    Thread.sleep(Utils.rand(1000, maxWaitingTime));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                waiting = true;
                while (!to.addContainer(container)) {
                    Utils.threadWait();
                }
                System.out.println(name + " added " + container.getName() + " to " + to.getName());
            }

            else {
                Utils.threadWait();
            }
        }
    }

    public void handleContainer(Container container) {}

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
