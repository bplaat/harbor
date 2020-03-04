package ml.bastiaan.containership;

import java.util.UUID;

public class Container {
    public enum Type {
        STANDARD,
        HEATED,
        COOLED
    }

    private final UUID uuid;
    private Type type;

    public Container() {
        uuid = UUID.randomUUID();

        int randomTypeNumber = (int)(Math.random() * 3);
        if (randomTypeNumber == 0) type = Type.STANDARD;
        if (randomTypeNumber == 1) type = Type.HEATED;
        if (randomTypeNumber == 2) type = Type.COOLED;
    }

    public UUID getUUID() {
        return uuid;
    }

    public Type getType() {
        return type;
    }
}
