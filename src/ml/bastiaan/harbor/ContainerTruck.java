// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class ContainerTruck extends Truck {
    public ContainerTruck(String name, ItemHolder from, ItemHolder to) {
        super(name, from, to, "Container");
    }

    @Override
    public void handleItem(Item item) {
        Container container = (Container)item;
        if (container.getType() == Container.Type.HEATED) {
            System.out.println(name + " connect " + container.getName() + " to a heat element");
        }
        if (container.getType() == Container.Type.COOLED) {
            System.out.println(name + " connect " + container.getName() + " to a cooling element");
        }

        try {
            Thread.sleep(Utils.rand(1000, 4000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
