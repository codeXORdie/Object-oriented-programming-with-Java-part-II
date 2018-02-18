
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Victoria (Nur) Acar
 */
public class Participant implements Comparable<Participant>{
    
    private final String name; 
    private int points;
    private Map<Participant, Integer> pointMap;
    private List<Integer> lengths;
    
    public Participant(String name) {
        this.name = name;
        points = 0;
        pointMap = new HashMap<Participant, Integer>();
        lengths = new ArrayList<Integer>();
    }
    
    //adding a participant into a Map with initial point score = 0
    public void addParticipant(Participant p) {
        pointMap.put(p, 0);
    }
    
    //holding all jumps lengths 
    public void addJump(int length) {
        lengths.add(length);
    }
    
  
    public String getName() {
        return name;
    }
    
    public List<Integer> getLengths() {
        return lengths;
    }
    
    public int getPoints(Participant p) {
        return pointMap.get(p);
    }
    
    public void setPoints(Participant p, int points) {
        this.points += points;
        pointMap.put(p, pointMap.get(p)+points);
        
    }

    @Override
    public int compareTo(Participant p) {
        return this.points - p.points;
    }
    
    @Override
    public String toString() {
        return name + " (" + points + ")";
    }
}
