// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

// The container ship is just an Item Holder with a max count of 100
public class ContainerShip extends ItemHolder {
    public ContainerShip(String name) {
        super(name, 100);
    }

    // When started create the containers
    @Override
    public void start() {
        super.start();
        for (int i = 1; i <= getMaxCount(); i++) {
            items.add(new Container("Container " + i));
        }
    }
}
