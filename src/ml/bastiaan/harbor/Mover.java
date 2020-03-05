// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

abstract public class Mover implements Runnable {
    protected final String name;
    protected final ContainerHolder from;
    protected final ContainerHolder to;
    protected final int maxWaitingTime;
    protected Thread thread;
    protected volatile boolean running = false;
    protected volatile boolean playing = false;
    protected volatile boolean waiting = true;
    protected volatile Container container;

    public Mover(String name, ContainerHolder from, ContainerHolder to, int maxWaitingTime) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.maxWaitingTime = maxWaitingTime;
    }

    public void run() {
        while (running) {
            if (playing) {
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
            else {
                Utils.threadWait();
            }
        }
    }

    public void handleContainer(Container container) {}

    public void start() {
        running = true;
        playing = true;
        waiting = true;
        thread = new Thread(this, name);
        thread.start();
    }

    public void stop () {
        running = false;
        playing = false;
        waiting = true;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play () {
        playing = true;
        waiting = true;
    }

    public void pause () {
        playing = false;
        waiting = true;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isPlaying() {
        return playing;
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
