
/**
 *
 * @author Victoria (Nur) Acar
 */
public class Flight {
    
    private Plane plane;
    private String departure;
    private String destination;
    
    public Flight(Plane plane, String departure, String destination) {   
        this.destination = destination;
        this.departure = departure;
        this.plane = plane;
    }
    
    public Plane getPlane() {
        return plane;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getDestination() {
        return destination;
    }
    

}
