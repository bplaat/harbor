// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

public class Truck extends Mover {
    public Truck(String name, ContainerHolder from, ContainerHolder to) {
        super(name, from, to, 3000);
    }

    @Override
    public void handleContainer(Container container) {
        if (container.getType() == Container.Type.HEATED) {
            System.out.println(name + " connect " + container.getName() + " to a heat element");
        }
        if (container.getType() == Container.Type.COOLED) {
            System.out.println(name + " connect " + container.getName() + " to a cooling element");
        }
    }
}
