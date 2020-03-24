// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

// The container truck is just an truck
public class ContainerTruck extends Truck {
    public ContainerTruck(String name, ItemHolder from, ItemHolder to) {
        super(name, from, to, "Container");
    }

    // Print an extra message and just wait
    @Override
    public void handleItem(Item item) {
        // Print extra message when special container
        Container container = (Container)item;
        if (container.getType() == Container.Type.HEATED) {
            System.out.println(name + " connect " + container.getName() + " to a heat element");
        }
        if (container.getType() == Container.Type.COOLED) {
            System.out.println(name + " connect " + container.getName() + " to a cooling element");
        }

        // Wait to handle the container
        try {
            Thread.sleep(Utils.rand(1000, 4000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
