// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

public class Container {
    private static int containerNumber = 1;

    public enum Type {
        STANDARD,
        HEATED,
        COOLED
    }

    private final String name;
    private Type type;

    public Container() {
        name = "Container " + containerNumber++;

        int randomTypeNumber = Utils.rand(0, 2);
        if (randomTypeNumber == 0) type = Type.STANDARD;
        if (randomTypeNumber == 1) type = Type.HEATED;
        if (randomTypeNumber == 2) type = Type.COOLED;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
