
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Victoria (Nur) Acar
 */
public class FlightUtils {
    
    private List<Flight> flights;
    
    public FlightUtils() {
        flights = new ArrayList<Flight>();
    }
    
    public void addFlight(Flight f) {
        if(!flights.contains(f)) {
            flights.add(f);
        }
    }
    
    public void printFlights() {
        for(Flight f : flights) {
            System.out.println(f.getPlane().toString() + " (" + f.getDeparture() + "-" +
                    f.getDestination() + ")");
        }
    }

}
