package boxes;

import java.util.Objects;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        
        if(weight < 0) {
            throw new IllegalArgumentException();
        }
        
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Thing)) return false;
        Thing other = (Thing) o;
        return this.name.equals(other.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
