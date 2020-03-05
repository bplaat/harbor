// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class Crane extends Mover {
    public Crane(String name, ContainerHolder from, ContainerHolder to) {
        super(name, from, to);
    }

    @Override
    public void handleContainer(Container container) {
        try {
            Thread.sleep(Utils.rand(1000, 2000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
