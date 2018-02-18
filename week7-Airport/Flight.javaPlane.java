

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Victoria (Nur) Acar
 */
public class Plane {
    
    private String planeID;
    private String planeCapasity;
   
    
    public Plane(String id, String capasity) {
        planeID = id;
        planeCapasity = capasity;
    }
    
    public String getPlaneID() {
        return planeID;
    }
    
    public String getCapasity() {
        return planeCapasity;
    }
    
    
    @Override
    public String toString() {
        return planeID + " (" + planeCapasity + " ppl)";
    }
}
