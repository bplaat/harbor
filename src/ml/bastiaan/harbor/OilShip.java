// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

// The oil ship is just an Item Holder with a max of 100
public class OilShip extends ItemHolder {
    public OilShip(String name) {
        super(name, 100);
    }

    // And it creates an start all the oil barrel items
    @Override
    public void start() {
        super.start();
        for (int i = 1; i <= getMaxCount(); i++) {
            items.add(new OilBarrel("Oil Barrel " + i));
        }
    }
}
