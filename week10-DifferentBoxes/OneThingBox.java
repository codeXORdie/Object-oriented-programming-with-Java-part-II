
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class OneThingBox extends Box{
    
    private List<Thing> thing;
    
    public OneThingBox() {
        this.thing = new ArrayList<Thing>();
    }
    

    @Override
    public void add(Thing thing) {
        if(this.thing.isEmpty()) 
            this.thing.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(this.thing.isEmpty()) return false;
        return this.thing.get(0).equals(thing);
    }

}
