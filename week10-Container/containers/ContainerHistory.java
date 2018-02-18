
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Victoria (Nur) Acar
 */
public class ContainerHistory {
    
    private List<Double> list;
    
    public ContainerHistory() {
        list = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        list.add(situation);
    }
    
    public void reset() {
        list.clear();
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
    
    public double maxValue() {
        if(list.isEmpty()) return 0;
        return Collections.max(list);
    }
    
    public double minValue() {
        if(list.isEmpty()) return 0;
        return Collections.min(list);
    }
    
    public double average() {
        if(list.isEmpty()) return 0;
        double sum = 0;
        for(double d : list) {
            sum += d;
        }
        return sum / list.size();
    }
    
    
    public double greatestFluctuation() {
        if(list.isEmpty() || list.size() == 1) return 0;
        double fluctuation = Math.abs(list.get(0)-list.get(1));
        for(int x=0; x<list.size()-1; x++) {
            double d = Math.abs(list.get(x)-list.get(x+1));
            if(d > fluctuation) fluctuation = d;
        }
        
        return fluctuation;
    }
    
    public double variance() {
        if(list.isEmpty() || list.size() == 1) return 0;
        double variance = 0;
        double avg = average();
        for(double d : list) {
            double toPow = d - avg;
            variance += toPow * toPow;
        }
        return variance / (list.size()-1);
    }
    
    

}
