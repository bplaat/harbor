// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

import java.util.ArrayList;

abstract public class ContainerHolder {
    protected final ArrayList<Container> containers;

    public ContainerHolder() {
        containers = new ArrayList<Container>();
    }

    abstract public int getMaxCount();

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
        if (containers.size() > 0) {
            return containers.remove(Utils.rand(0, containers.size() - 1));
        } else {
            return null;
        }
    }
}
