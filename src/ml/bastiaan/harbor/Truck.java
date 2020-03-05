// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class Truck extends Mover {
    public Truck(String name, ContainerHolder from, ContainerHolder to) {
        super(name, from, to);
    }

    @Override
    public void handleContainer(Container container) {
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
