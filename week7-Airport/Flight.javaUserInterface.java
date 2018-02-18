
import java.util.Scanner;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class UserInterface {

    Scanner sc;
    PlaneUtils pu;
    FlightUtils fu;
    
    public UserInterface() {
        sc = new Scanner(System.in);
        pu = new PlaneUtils();
        fu = new FlightUtils();
    }
    
    public void start() {
        System.out.println("Airport panel\n" +
                            "--------------------");
        while(true) {
            
            System.out.println("Choose operation:\n" +
                            "[1] Add airplane\n" +
                            "[2] Add flight\n" +
                            "[x] Exit");

            String input = sc.nextLine();

            if(input.equals("1")) {
                System.out.println("Give plane ID:");
                String id = sc.nextLine();
                System.out.println("Give plane capacity:");
                String capasity = sc.nextLine();
                Plane p = new Plane(id, capasity);
                pu.addPlane(p);
            }
            if(input.equals("2")) {
                System.out.println("Give plane ID:");
                String id = sc.nextLine();
                System.out.println("Give departure airport code:");
                String departure = sc.nextLine();
                System.out.println("Give destination airport code:");
                String destination = sc.nextLine();
                Plane p = pu.getPlaneById(id);
                Flight f = new Flight(p, departure, destination);
                fu.addFlight(f);
            }
            if(input.equals("x")) {
                startFlightService();
                break;
            }
        }
    }

    private void startFlightService() {
        System.out.println("Flight service\n" +
                            "------------");
        
        while(true) {
            
            System.out.println("Choose operation:\n" +
                                "[1] Print planes\n" +
                                "[2] Print flights\n" +
                                "[3] Print plane info\n" +
                                "[x] Quit");
            String input = sc.nextLine();
            if(input.equals("1")) {
                pu.printPlanes();
            }
            if(input.equals("2")) {
                fu.printFlights();
            }
            if(input.equals("3")) {
                System.out.println("Give plane ID:");
                String id = sc.nextLine();
                System.out.println(pu.getPlaneById(id).toString());
            }
            if(input.equals("x")) {
                sc.close();
                break;
            }
        }
    }
    
    

}
