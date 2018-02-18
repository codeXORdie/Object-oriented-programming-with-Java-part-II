
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class Phonebook {

    private Map<String, List<String>> book;
    private Map<String, Person> address;

    public Phonebook() {
        book = new HashMap<String, List<String>>();
        address = new HashMap<String, Person>();
    }

    public void addNumber(String name, String number) {
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<String>());
        }
        book.get(name).add(number);
    }

    public void getNumber(String name) {
        if (book.containsKey(name)) {
            ArrayList<String> numbers = (ArrayList) book.get(name);
            for (String n : numbers) {
                System.out.println(n);
            }
        } else {
            System.out.println("  not found");
        }
    }

    public void getNameByNumber(String number) {
        Set<Map.Entry<String, List<String>>> entries = book.entrySet();
        String s = "";
        for (Map.Entry<String, List<String>> entry : entries) {
            if (entry.getValue().contains(number)) {
                s = entry.getKey();
            }
        }
        if (!s.isEmpty()) {
            System.out.println(" " + s);
        } else {
            System.out.println(" not found");
        }
    }

    public void addAddress(String name, Person p) {
        address.put(name, p);
    }

    public void getPersonalInfo(String name) {
        //if unknown
        if (!address.containsKey(name) && !book.containsKey(name)) {
            System.out.println("  not found");
        } else {
            //address
            if (!address.containsKey(name)) {
                System.out.println("  address unknown");
            } else {
                System.out.println("  address: " + address.get(name).getAddress());
            }
            //phone numbers
            if (book.containsKey(name)) {
                List<String> phones = book.get(name);
                System.out.println("  phone numbers:");
                for (String phone : phones) {
                    System.out.println("   " + phone);
                }
            } else {
                System.out.println("  phone number not found");
            }
        }
    }

    public void delete(String name) {
        if (book.containsKey(name)) {
            book.remove(name);
        }
        if (address.containsKey(name)) {
            address.remove(name);
        }
    }

    public void keywordSearch(String keyword) {
        SortedSet<String> found = new TreeSet<String>();
        //search in book
        Set<Map.Entry<String, List<String>>> entries = book.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            if (entry.getValue().contains(keyword) || entry.getKey().contains(keyword)) {
                found.add(entry.getKey());
            }
        }
        //search in address
        Set<Map.Entry<String, Person>> set = address.entrySet();
        for (Map.Entry<String, Person> s : set) {
            if (s.getValue().getAddress().contains(keyword)
                    || s.getValue().getCity().contains(keyword)
                    || s.getValue().getName().contains(keyword)
                    || s.getKey().contains(keyword)) {
                found.add(s.getKey());
            }
        }
        //if still not found, sout "not found"
        if (isEmpty(found)) {
            System.out.println(" keyword not found");
        }
    }

    private boolean isEmpty(SortedSet<String> found) {
        if (found.isEmpty()) {
            return true;
        }
        //process
        displayKeyword(found);
        return false;
    }

    private void displayKeyword(SortedSet<String> set) {
        for(String s : set) {
            System.out.println(" " + s);
            getPersonalInfo(s);
        }
    }

}
