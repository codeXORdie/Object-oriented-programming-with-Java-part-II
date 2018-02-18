
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class Cow implements Alive, Milkable{
    
    private Random rand;
    private final String name;
    private final double udder;
    private double availableMilk;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }
    
    public Cow(String name) {
        this.name = name;
        udder = 15 + new Random().nextInt(26);
        availableMilk = 0;
    }
    
    public String getName() {
        return name;
    }
    
    //return cow's udder
    public double getCapacity() {
        return udder;
    }
    
    //returns available milk
    public double getAmount() {
        return availableMilk;
    }
    
    @Override
    public String toString() {
        return String.format("%s %f/%f%n", name, Math.ceil(availableMilk), Math.ceil(udder));
    }

    @Override
    public void liveHour() {
        double milk = 0.7 + (2 - 0.7) * new Random().nextDouble();
        if(availableMilk + milk <= udder) {
            availableMilk += milk;
            return;
        }
        availableMilk = udder;
    }

    @Override
    public double milk() {
        double milk = availableMilk;
        availableMilk = 0;
        return milk;
    }

}
