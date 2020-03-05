// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class Truck extends ItemMover {
    public enum Type {
        CONTAINER,
        OIL_BARREL
    }

    private Type type;

    public Truck(String name, ItemHolder from, ItemHolder to, Type type) {
        super(name, from, to);
        this.type = type;
        if (this.type == Type.CONTAINER) {
            this.itemNamePrefix = "Container";
        }
        if (this.type == Type.OIL_BARREL) {
            this.itemNamePrefix = "Oil Barrel";
        }
    }

    @Override
    public void handleItem(Item item) {
        if (item instanceof Container) {
            Container container = (Container)item;
            if (container.getType() == Container.Type.HEATED) {
                System.out.println(name + " connect " + container.getName() + " to a heat element");
            }
            if (container.getType() == Container.Type.COOLED) {
                System.out.println(name + " connect " + container.getName() + " to a cooling element");
            }
        }

        try {
            Thread.sleep(Utils.rand(1000, 4000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
