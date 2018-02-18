
import java.util.Scanner;


/**
 *
 * @author Victoria (Nur) Acar
 */
public class UI {
    
    private Scanner sc;
    private Phonebook book;
    
    public UI() {
        sc = new Scanner(System.in);
        book = new Phonebook();
    }

    public void start() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
        
        readInput();
    }

    private void readInput() {
        while(true) {
            System.out.print("command: ");
            String input = sc.nextLine();
            if(input.equals("1")) {
                //add number to phonebook
                String name = askForName();
                String number = askForNumber();
                book.addNumber(name, number);
            }
            if(input.equals("2")) {
                //search for a number
                book.getNumber(askForName());
            }
            if(input.equals("3")) {
                //search for a person by phone number
                book.getNameByNumber(askForNumber());
            }
            if(input.equals("4")) {
                //add an address
                System.out.print("whose address: ");
                String name = sc.nextLine();
                System.out.print("street: ");
                String street = sc.nextLine();
                System.out.print("city: ");
                String city = sc.nextLine();
                Person p = new Person(name, street, city);
                book.addAddress(name, p);
            }
            if(input.equals("5")) {
                //search for personal information
                System.out.print("whose information: ");
                String name = sc.nextLine();
                book.getPersonalInfo(name);
            }
            if(input.equals("6")) {
                //delete personal information
                System.out.print("whose information: ");
                String name = sc.nextLine();
                book.delete(name);
            }
            if(input.equals("7")) {
                //filtered listing
                System.out.print("keyword (if empty, all listed): ");
                String keyword = sc.nextLine();
                book.keywordSearch(keyword);
                //if empty, list all
            }
            if(input.equals("x")) {
                sc.close();
                break;
            }
        }
    }
    
    private String askForName() {
        System.out.print("whose number: ");
        return sc.nextLine();
    }
    
    private String askForNumber() {
        System.out.print("number: ");
        String number = sc.nextLine();
        return number;
    }


}
