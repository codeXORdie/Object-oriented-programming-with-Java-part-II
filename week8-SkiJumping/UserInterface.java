
import java.util.Scanner;


/**
 *
 * @author Victoria (Nur) Acar
 */
public class UserInterface {
    
    private Scanner sc;
    private JumpingSimulator js;
    
    public UserInterface() {
        sc = new Scanner(System.in);
        js = new JumpingSimulator();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week\n\n");
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        
        while(true) {
            System.out.println("  Participant name:");
            String input = read();
            if(!input.isEmpty()) {
                Participant p = new Participant(input);
                p.addParticipant(p);
                js.addParticipant(p);
            } else {
                runSimulator();
                break;
            }
        }
        
    }
    
    private String read() {
        return sc.nextLine();
    }
    
    private void runSimulator() {
        System.out.println("\n\nThe tournament begins!");
        int count = 1;
        while(true) {
            System.out.print("\n\nWrite \"jump\" to jump; otherwise you quit: ");
            String input = read();
            if(input.equals("jump")) {
                System.out.println("\n\nRound " + count + "\n\n");
                System.out.println("Jumping order:");
                js.printList();
                //simulate and print results
                System.out.println("\n\nResults of round " + count);
                js.jump();
                js.vote();
                js.setPoints();
                js.Results();
                count++;
            } else {
                sc.close();
                processResults();
                break;
            }
        }
    }

    private void processResults() {
        System.out.println("\n\nThanks!\n\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        js.processResults();
    }

}
