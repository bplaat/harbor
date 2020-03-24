// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

// The oil pump is just an Item Mover
public class OilPump extends ItemMover {
    public OilPump(String name, ItemHolder from, ItemHolder to) {
        super(name, from, to, "Oil Barrel");
    }

    // It waits to handle an item
    @Override
    public void handleItem(Item item) {
        try {
            Thread.sleep(Utils.rand(1000, 2000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
