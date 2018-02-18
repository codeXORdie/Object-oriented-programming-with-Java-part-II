package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }

    public String history() {
        return history.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        history.add(super.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        history.add(super.getVolume() - amount);
        return super.takeFromTheContainer(amount);
    }
    
    public void printAnalysis() {
        System.out.printf("Product: %s%nHistory: %s%nGreatest product amount: %.1f%nSmallest product amount: %.1f%n"
                + "Average: %.1f%nGreatest change: %f%nVariance: %f", 
                super.getName(), history(), history.maxValue(), history.minValue(), history.average(), 
                history.greatestFluctuation(), history.variance());
        
    }

}
