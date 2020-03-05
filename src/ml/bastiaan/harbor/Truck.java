// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

// A truck is just a specific Item Mover
abstract public class Truck extends ItemMover {
    public Truck(String name, ItemHolder from, ItemHolder to, String itemNamePrefix) {
        super(name, from, to, itemNamePrefix);
    }
}
