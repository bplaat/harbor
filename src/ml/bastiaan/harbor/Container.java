// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

// The container class is just an Item
public class Container extends Item {
    // The container type enum
    public enum Type {
        STANDARD,
        HEATED,
        COOLED
    }

    // The container data fields
    private Type type;

    public Container(String name) {
        super(name);

        // When create chose a random type and change name if necessary
        int randomTypeNumber = Utils.rand(0, 2);
        if (randomTypeNumber == 0) {
            type = Type.STANDARD;
        }
        if (randomTypeNumber == 1) {
            this.name = name + " (H)";
            type = Type.HEATED;
        }
        if (randomTypeNumber == 2) {
            this.name = name + " (C)";
            type = Type.COOLED;
        }
    }

    // Get the container type
    public Type getType() {
        return type;
    }
}
