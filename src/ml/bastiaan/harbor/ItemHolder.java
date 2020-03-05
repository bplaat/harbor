// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.util.ArrayList;

// The abstract ItemHolder class
abstract public class ItemHolder {
    // The data fields
    protected final String name;
    protected final int maxCount;
    protected boolean running = false;
    protected boolean playing = false;
    protected ArrayList<Item> items;

    public ItemHolder(String name, int maxCount) {
        // Set some data
        this.name = name;
        this.maxCount = maxCount;
    }

    // Get the name
    public String getName() {
        return name;
    }

    // Get the max count
    public int getMaxCount() {
        return maxCount;
    }

    // Start the item holder
    public void start() {
        running = true;
        playing = true;
        items = new ArrayList<Item>();
    }

    // Stop the item holder
    public void stop () {
        running = false;
        playing = false;
    }

    // Play the item holder
    public void play () {
        playing = true;
    }

    // Pause the item holder
    public void pause () {
        playing = false;
    }

    // Is the item holder running
    public boolean isRunning() {
        return running;
    }

    // Is the item holder playing
    public boolean isPlaying() {
        return playing;
    }

    // Get the item holder items
    public ArrayList<Item> getItems() {
        return items;
    }

    // Add synchronized a item to the item holder when there is room
    public synchronized boolean addItem(Item item) {
        if (items.size() < getMaxCount()) {
            items.add(item);
            return true;
        } else {
            return false;
        }
    }

    // Remove synchronized a item from the item holder
    public synchronized Item removeItem(String namePrefix) {
        // First get all the good items via the name prefix
        ArrayList<Integer> goodItems = new ArrayList<Integer>();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().startsWith(namePrefix)) {
                goodItems.add(i);
            }
        }

        // The filter the non standard containers
        ArrayList<Integer> specialItems = new ArrayList<Integer>();
        for (int i = 0; i < goodItems.size(); i++) {
            Item item = items.get(goodItems.get(i));
            if (item instanceof Container) {
                Container container = (Container)item;
                if (container.getType() != Container.Type.STANDARD) {
                    specialItems.add(goodItems.get(i));
                }
            }
        }

        // First give a non standard container
        if (specialItems.size() > 0) {
            return items.remove((int)specialItems.get(Utils.rand(0, specialItems.size() - 1)));
        }

        // Else try to give a other item
        else if (goodItems.size() > 0) {
            return items.remove((int)goodItems.get(Utils.rand(0, goodItems.size() - 1)));
        }

        // When empty return null
        else {
            return null;
        }
    }
}
