// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.util.ArrayList;

public class OilShip extends ItemHolder {
    public OilShip(String name) {
        super(name, 100);
    }

    @Override
    public void start() {
        super.start();
        for (int i = 1; i <= getMaxCount(); i++) {
            items.add(new OilBarrel("Oil Barrel " + i));
        }
    }
}
