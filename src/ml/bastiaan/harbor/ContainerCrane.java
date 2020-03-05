// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

// The container crane is just an Item Mover
public class ContainerCrane extends ItemMover {
    public ContainerCrane(String name, ItemHolder from, ItemHolder to) {
        super(name, from, to, "Container");
    }

    // Just wait to handle the item
    @Override
    public void handleItem(Item item) {
        try {
            Thread.sleep(Utils.rand(1000, 2000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
