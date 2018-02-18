
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class Farm implements Alive {
    
    private final String ownerName;
    private final Barn barn;
    private List<Cow> cows;
    
    
    public Farm(String name, Barn barn) {
        this.ownerName = name;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }
    
    public String getOwner() {
        return ownerName;
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
    
    @Override
    public String toString() {
        String s = String.format("Farm owner: %s%nBarn bulk tank: %s%n", getOwner(), barn.toString());
        if(cows.isEmpty()) s += "No cows.";
        else {
            s += "Animals:\n";
            for(Cow c : cows) {
                s = s + "        " + c.toString();
            }
        }
        return s;
    }

    @Override
    public void liveHour() {
        for (Cow c : cows) {
            c.liveHour();
        }
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    

}
