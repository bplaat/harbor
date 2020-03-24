// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

// The abstract Item class
abstract public class Item {
    protected String name;

    // Set the item name
    public Item(String name) {
        this.name = name;
    }

    // Get the item name
    public String getName() {
        return name;
    }
}
