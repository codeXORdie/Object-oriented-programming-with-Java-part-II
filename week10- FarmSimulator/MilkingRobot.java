
package farmsimulator;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class MilkingRobot {
    
    private BulkTank tank;
    
    public MilkingRobot() {
        tank = null;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public BulkTank getBulkTank() {
        return tank;
    }

    public void milk(Milkable milkable) {
        try {
            tank.addToTank(milkable.milk());
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

}
