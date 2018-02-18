
import java.util.Scanner;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statements:\n"
                + "  add - adds a word pair to the dictionary\n"
                + "  translate - asks a word and prints its translation\n"
                + "  quit - quit the text user interface");

        while (true) {
            System.out.print("Statement: ");
            String input = reader.nextLine();
            if(input.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if(input.equals("add")) {
                add();
            } else if(input.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }
    
    public void add() {
        System.out.println("In Finnish:");
        String fin = reader.nextLine();
        System.out.println("Translation:");
        String en = reader.nextLine();
        dictionary.add(fin, en);
    }
    
    public void translate() {
        System.out.println("Give a word:");
        String word = reader.nextLine();
        System.out.println(dictionary.translate(word));
    }

}
