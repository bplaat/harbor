// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

// The Item Mover abstract runnable class
abstract public class ItemMover implements Runnable {
    // The data fields
    protected final String name;
    protected final ItemHolder from;
    protected final ItemHolder to;
    protected final String itemNamePrefix;

    // The thread data fields
    protected Thread thread;
    protected volatile boolean running = false;
    protected volatile boolean playing = false;
    protected volatile boolean waiting = true;
    protected volatile Item item;

    public ItemMover(String name, ItemHolder from, ItemHolder to, String itemNamePrefix) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.itemNamePrefix = itemNamePrefix;
    }

    // The thread run method
    public void run() {
        // Loop until not running
        while (running) {
            // Check if playing
            if (playing) {
                // Try to get an item for the from Item Holder
                item = from.removeItem(itemNamePrefix);
                if (item != null) {
                    waiting = false;
                    System.out.println(name + " removed " + item.getName() + " from " + from.getName());

                    // Handle the item
                    handleItem(item);

                    // Wait until the item is added to the to Item Holder
                    waiting = true;
                    while (!to.addItem(item)) {
                        Utils.threadWait();
                    }
                    System.out.println(name + " added " + item.getName() + " to " + to.getName());
                }

                // Or wait a short period
                else {
                    Utils.threadWait();
                }
            }

            // Or wait a short period
            else {
                Utils.threadWait();
            }
        }
    }

    // Every item mover must handle the item
    abstract public void handleItem(Item item);

    // Start the item mover and create the worker thread
    public void start() {
        running = true;
        playing = true;
        waiting = true;
        thread = new Thread(this, name);
        thread.start();
    }

    // Stop the item mover
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

    // Play the item mover
    public void play () {
        playing = true;
        waiting = true;
    }

    // Pause the item mover
    public void pause () {
        playing = false;
        waiting = true;
    }

    // Is the item mover running
    public boolean isRunning() {
        return running;
    }

    // Is the item mover playing
    public boolean isPlaying() {
        return playing;
    }

    // Get the item mover name
    public String getName() {
        return name;
    }

    // Is the item mover waiting
    public boolean isWaiting() {
        return waiting;
    }

    // Get the current item
    public Item getItem() {
        return item;
    }
}
