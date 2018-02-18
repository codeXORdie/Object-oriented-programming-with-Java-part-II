
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class Barn {
    
    private final BulkTank tank;
    private MilkingRobot robot;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
        robot = null;
    }
    
    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        robot = milkingRobot;
        robot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        try {
            robot.milk(cow);
        } catch(Exception e) {
            throw new IllegalStateException();
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for(Cow c : cows)
            takeCareOf(c);
    }
    
    @Override
    public String toString() {
        return tank.toString();
    }

}
