// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

abstract public class ItemMover implements Runnable {
    protected final String name;
    protected final ItemHolder from;
    protected final ItemHolder to;
    protected String itemNamePrefix;
    protected Thread thread;
    protected volatile boolean running = false;
    protected volatile boolean playing = false;
    protected volatile boolean waiting = true;
    protected volatile Item item;

    public ItemMover(String name, ItemHolder from, ItemHolder to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public void run() {
        while (running) {
            if (playing) {
                item = from.removeItem(itemNamePrefix);
                if (item != null) {
                    waiting = false;
                    System.out.println(name + " removed " + item.getName() + " from " + from.getName());

                    handleItem(item);

                    waiting = true;
                    while (!to.addItem(item)) {
                        Utils.threadWait();
                    }
                    System.out.println(name + " added " + item.getName() + " to " + to.getName());
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

    abstract public void handleItem(Item item);

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

    public Item getItem() {
        return item;
    }
}
