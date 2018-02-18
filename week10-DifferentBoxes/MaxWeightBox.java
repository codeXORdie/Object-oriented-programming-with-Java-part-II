
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class MaxWeightBox extends Box {
    
    private final int maxWeight;
    private List<Thing> box;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        box = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if(thing.getWeight() + boxWeight() <= maxWeight) {
            box.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return box.contains(thing);
    }
    
    private int boxWeight() {
        int totalWeight = 0;
        for(Thing th : box)
            totalWeight += th.getWeight();
        return totalWeight;
    }

}
