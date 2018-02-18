
package farmsimulator;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class BulkTank {
    
   private final double tankCapacity;
   private double volumeUsed;
   
   public BulkTank() {
       this(2000);
   }
   
   public BulkTank(double capacity) {
       this.tankCapacity = capacity;
       volumeUsed = 0;
   }
   
   public double getCapacity() {
       return tankCapacity;
   }
   
   public double getVolume() {
       return volumeUsed;
   }
   
   public double howMuchFreeSpace() {
       return tankCapacity - volumeUsed;
   }
   
   public void addToTank(double amount) {
       if(volumeUsed + amount <= tankCapacity) {
           volumeUsed += amount;
           return;
       }
       volumeUsed = tankCapacity;
   }
   
   public double getFromTank(double amount) {
       if(amount <= volumeUsed) {
           volumeUsed -= amount;
           return amount;
       }
       double left = volumeUsed;
       volumeUsed = 0;
       return left;
   }
   
   @Override
   public String toString() {
       return Math.ceil(volumeUsed) + "/" + Math.ceil(tankCapacity);
   }

}
