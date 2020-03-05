// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class Container {
    public enum Type {
        STANDARD,
        HEATED,
        COOLED
    }

    private String name;
    private Type type;

    public Container(int number) {
        int randomTypeNumber = Utils.rand(0, 2);
        if (randomTypeNumber == 0) {
            name = "Container " + number;
            type = Type.STANDARD;
        }
        if (randomTypeNumber == 1) {
            name = "Container " + number + " (H)";
            type = Type.HEATED;
        }
        if (randomTypeNumber == 2) {
            name = "Container " + number + " (C)";
            type = Type.COOLED;
        }
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
