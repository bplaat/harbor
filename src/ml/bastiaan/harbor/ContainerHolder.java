// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.util.ArrayList;

abstract public class ContainerHolder {
    protected final String name;
    protected final int maxCount;
    protected boolean running = false;
    protected boolean playing = false;
    protected ArrayList<Container> containers;

    public ContainerHolder(String name, int maxCount) {
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
        containers = new ArrayList<Container>();
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

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public synchronized boolean addContainer(Container container) {
        if (containers.size() < getMaxCount()) {
            containers.add(container);
            return true;
        } else {
            return false;
        }
    }

    public synchronized Container removeContainer() {
        ArrayList<Integer> specialContainers = new ArrayList<Integer>();
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).getType() != Container.Type.STANDARD) {
                specialContainers.add(i);
            }
        }

        if (specialContainers.size() > 0) {
            return containers.remove((int)specialContainers.get(Utils.rand(0, specialContainers.size() - 1)));
        } else if (containers.size() > 0) {
            return containers.remove(Utils.rand(0, containers.size() - 1));
        } else {
            return null;
        }
    }
}
