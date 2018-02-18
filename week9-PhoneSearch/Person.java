
import java.util.List;


/**
 *
 * @author Victoria (Nur) Acar
 */
public class Person {
    
    private String name;
    private String city;
    private String street;
    
    public Person(String name, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
        
    }
    
    public String getAddress() {
        return street + " " + city;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getStreet() {
        return street;
    }

}
