// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class Container extends Item {
    public enum Type {
        STANDARD,
        HEATED,
        COOLED
    }

    private Type type;

    public Container(String name) {
        super(name);

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

    public Type getType() {
        return type;
    }
}
