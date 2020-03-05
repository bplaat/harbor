// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.util.ArrayList;

abstract public class ItemHolder {
    protected final String name;
    protected final int maxCount;
    protected boolean running = false;
    protected boolean playing = false;
    protected ArrayList<Item> items;

    public ItemHolder(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    public String getName() {
        return name;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void start() {
        running = true;
        playing = true;
        items = new ArrayList<Item>();
    }

    public void stop () {
        running = false;
        playing = false;
    }

    public void play () {
        playing = true;
    }

    public void pause () {
        playing = false;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isPlaying() {
        return playing;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public synchronized boolean addItem(Item item) {
        if (items.size() < getMaxCount()) {
            items.add(item);
            return true;
        } else {
            return false;
        }
    }

    public synchronized Item removeItem(String namePrefix) {
        ArrayList<Integer> goodItems = new ArrayList<Integer>();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getName().startsWith(namePrefix)) {
                goodItems.add(i);
            }
        }

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

        if (specialItems.size() > 0) {
            return items.remove((int)specialItems.get(Utils.rand(0, specialItems.size() - 1)));
        } else if (goodItems.size() > 0) {
            return items.remove((int)goodItems.get(Utils.rand(0, goodItems.size() - 1)));
        } else {
            return null;
        }
    }
}
