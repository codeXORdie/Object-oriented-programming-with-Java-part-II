
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victoria (Nur) Acar
 */
public class PlaneUtils {
    
    private List<Plane> planes;
     
    public PlaneUtils() {
        planes = new ArrayList<Plane>();
    }
    
    public void addPlane(Plane p) {
        if(!planes.contains(p)) {
            planes.add(p);
        }
    }
    
    public Plane getPlaneById(String id) {
        for(Plane p : planes) {
            if(p.getPlaneID().equals(id)) return p;
        }
        return null;
    }
    
    public void printPlanes() {
        for(Plane p : planes) {
            System.out.println(p.toString());
        }
    }

}
