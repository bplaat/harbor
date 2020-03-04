// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

import java.util.ArrayList;

public class ContainerShip extends ContainerHolder {
    public ContainerShip(String name) {
        super(name, 100);
        for (int i = 0; i < getMaxCount(); i++) {
            containers.add(new Container());
        }
    }
}
