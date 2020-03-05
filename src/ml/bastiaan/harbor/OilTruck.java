// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

public class OilTruck extends Truck {
    public OilTruck(String name, ItemHolder from, ItemHolder to) {
        super(name, from, to, "Oil Barrel");
    }

    @Override
    public void handleItem(Item item) {
        try {
            Thread.sleep(Utils.rand(1000, 4000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
